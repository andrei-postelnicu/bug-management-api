package com.developer.bugs.repository;

import com.developer.bugs.entity.Bug;
import com.developer.bugs.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {
    List<Bug> findByOwner(User owner);
    Optional<Bug> findByIdAndOwner(Long id, User owner);
}