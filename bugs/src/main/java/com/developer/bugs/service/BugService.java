package com.developer.bugs.service;

import com.developer.bugs.request.BugRequest;
import com.developer.bugs.response.BugResponse;
import java.util.List;

public interface BugService {
    List<BugResponse> getAllBugs(boolean resolved);
    BugResponse createBug(BugRequest bugRequest);
    BugResponse resolveBug(long id);
    void deleteBug(long id);
}