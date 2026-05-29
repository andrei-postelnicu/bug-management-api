package com.developer.bugs.service;

import com.developer.bugs.response.UserResponse;

import java.util.List;

public interface AdminService {
    List<UserResponse> getAllUsers();
    UserResponse promoteToAdmin(long userId);
    void deleteNonAdminUser(long userId);
}