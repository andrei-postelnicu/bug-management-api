package com.developer.bugs.controller;

import com.developer.bugs.request.PasswordUpdateRequest;
import com.developer.bugs.response.UserResponse;
import com.developer.bugs.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="User REST API Endpoints", description = "Operations related to the authenticated user")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "User information", description = "Retrieve authenticated user information")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public UserResponse getUserInfo() {
        return userService.getUserInfo();
    }

    @Operation(summary = "Delete account", description = "Delete account for the authenticated user")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteUser() {
        userService.deleteUser();
    }

    @Operation(summary = "Update password", description = "Update password for the authenticated user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/password")
    public void passwordUpdate(@Valid @RequestBody PasswordUpdateRequest passwordUpdateRequest)
            throws Exception {
        userService.updatePassword(passwordUpdateRequest);
    }
}