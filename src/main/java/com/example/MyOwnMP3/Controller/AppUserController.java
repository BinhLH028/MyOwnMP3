package com.example.MyOwnMP3.Controller;

import com.example.MyOwnMP3.Auth.AuthenticationService;
import com.example.MyOwnMP3.Auth.AuthenticationRequest;
import com.example.MyOwnMP3.Auth.AuthenticationResponse;
import com.example.MyOwnMP3.Auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping(value = "/API/AppUser")
public class AppUserController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    MessageSource messageSource;
    @PostMapping(path = "/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request) {
        try {
            return new ResponseEntity(authenticationService.register(request), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity(messageSource.getMessage("03", new String[]{request.getEmail()}, Locale.getDefault()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


    @PostMapping(path = "/confirm")
    public ResponseEntity<AuthenticationResponse> ConfirmRegistration(
            @RequestParam("token") String token) {
        return new ResponseEntity(authenticationService.confirmToken(token), HttpStatus.OK);
    }
}
