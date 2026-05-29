package com.developer.bugs.service;

import com.developer.bugs.request.PasswordUpdateRequest;
import com.developer.bugs.response.UserResponse;

public interface UserService {
    UserResponse getUserInfo();
    void deleteUser();
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);
}