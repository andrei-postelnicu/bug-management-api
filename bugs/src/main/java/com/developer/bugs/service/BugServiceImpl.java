package com.developer.bugs.service;

import com.developer.bugs.entity.Bug;
import com.developer.bugs.entity.User;
import com.developer.bugs.repository.BugRepository;
import com.developer.bugs.request.BugRequest;
import com.developer.bugs.response.BugResponse;
import com.developer.bugs.util.FindAuthenticatedUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;

    private final FindAuthenticatedUser findAuthenticatedUser;

    public BugServiceImpl(BugRepository bugRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.bugRepository = bugRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BugResponse> getAllBugs(boolean resolved) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        return bugRepository.findByOwner(currentUser)
                .stream()
                .filter(bug -> bug.isResolved() == resolved)
                .map(this::convertToBugResponse)
                .toList();
    }

    @Override
    @Transactional
    public BugResponse createBug(BugRequest bugRequest) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Bug bug = new Bug(
                bugRequest.getTitle(),
                bugRequest.getDescription(),
                bugRequest.getPriority(),
                false,
                currentUser
        );

        Bug savedBug = bugRepository.save(bug);

        return convertToBugResponse(savedBug);
    }

    @Override
    @Transactional
    public BugResponse resolveBug(long id) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Optional<Bug> bug = bugRepository.findByIdAndOwner(id, currentUser);

        if (bug.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bug not found");
        }

        bug.get().setResolved(!bug.get().isResolved());
        Bug updatedBug = bugRepository.save(bug.get());

        return convertToBugResponse(updatedBug);
    }

    @Override
    @Transactional
    public void deleteBug(long id) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Optional<Bug> bug = bugRepository.findByIdAndOwner(id, currentUser);

        if (bug.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bug not found");
        }
        bugRepository.delete(bug.get());
    }

    private BugResponse convertToBugResponse(Bug bug) {
        return new BugResponse(
                bug.getId(),
                bug.getTitle(),
                bug.getDescription(),
                bug.getPriority(),
                bug.isResolved()
        );
    }
}