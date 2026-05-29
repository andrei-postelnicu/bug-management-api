package com.developer.bugs.controller;

import com.developer.bugs.response.UserResponse;
import com.developer.bugs.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin REST API Endpoints", description = "Admin operations")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(summary = "Get all users", description = "Retrieve a list of all users in the system")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return adminService.getAllUsers();
    }

    @Operation(summary = "Assign admin role", description = "Assign the admin role to a user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{userId}/role")
    public UserResponse promoteToAdmin(@PathVariable @Min(1) long userId) {
        return adminService.promoteToAdmin(userId);
    }

    @Operation(summary = "Delete non-admin user", description = "Delete a non-admin user from the system")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable @Min(1) long userId) {
        adminService.deleteNonAdminUser(userId);
    }

}