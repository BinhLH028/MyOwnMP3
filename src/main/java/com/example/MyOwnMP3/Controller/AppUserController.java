package com.example.MyOwnMP3.Controller;

import com.example.MyOwnMP3.Service.AuthenticationService;
import com.example.MyOwnMP3.auth.AuthenticationRequest;
import com.example.MyOwnMP3.auth.AuthenticationResponse;
import com.example.MyOwnMP3.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/AppUser")
public class AppUserController {

    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
