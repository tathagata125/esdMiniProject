package com.esd.assignment.controllers;

import com.esd.assignment.dto.LoginRequest;
import com.esd.assignment.dto.LoginResponse;
import com.esd.assignment.dto.RegisterRequest;
import com.esd.assignment.entities.Admin;
import com.esd.assignment.services.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esd.assignment.services.AuthenticationService;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(authenticationService.registerAdmin(registerRequest), HttpStatus.OK);
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<LoginResponse> loginAdmin(@RequestBody LoginRequest loginRequest) {
        Admin loginAdmin = authenticationService.loginAdmin(loginRequest);
        String jwtToken = jwtService.generateToken(loginAdmin);
        LoginResponse loginResponse = new LoginResponse()
                .setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

}
