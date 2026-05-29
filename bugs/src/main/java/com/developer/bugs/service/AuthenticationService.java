package com.developer.bugs.service;

import com.developer.bugs.request.AuthenticationRequest;
import com.developer.bugs.request.RegisterRequest;
import com.developer.bugs.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}