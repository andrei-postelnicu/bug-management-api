package com.developer.bugs.controller;

import com.developer.bugs.request.BugRequest;
import com.developer.bugs.response.BugResponse;
import com.developer.bugs.service.BugService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bug REST API Endpoints", description = "Operations for managing the authenticated user's bugs")
@RestController
@RequestMapping("/api/bugs")
public class BugController {

    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @Operation(summary = "Get all bugs", description = "Fetch all bugs for the authenticated user")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<BugResponse> getAllBugs(@RequestParam(defaultValue = "false") boolean resolved) { return bugService.getAllBugs(resolved); }

    @Operation(summary = "Create a bug", description = "Create a bug for the authenticated user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BugResponse createBug(@Valid @RequestBody BugRequest bugRequest) {
        return bugService.createBug(bugRequest);
    }

    @Operation(summary = "Mark a bug as resolved", description = "Resolve a bug for the authenticated user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public BugResponse resolveBug(@PathVariable @Min(1) long id) {
        return bugService.resolveBug(id);
    }

    @Operation(summary = "Delete a bug", description = "Delete a bug for the authenticated user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteBug(@PathVariable @Min(1) long id) {
        bugService.deleteBug(id);
    }
}