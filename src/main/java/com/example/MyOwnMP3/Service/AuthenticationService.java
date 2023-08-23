package com.example.MyOwnMP3.Service;

import com.example.MyOwnMP3.Enum.Role;
import com.example.MyOwnMP3.Model.AppUser;
import com.example.MyOwnMP3.Repository.AppUserRepository;
import com.example.MyOwnMP3.auth.AuthenticationRequest;
import com.example.MyOwnMP3.auth.AuthenticationResponse;
import com.example.MyOwnMP3.auth.RegisterRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        var appUser = new AppUser(request.getFirstname() + request.getLastname(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail(),
                Role.USER);
        appUserRepository.save(appUser);
        var jwtToken = jwtService.generateToken(appUser);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
            )
        );
        var appUser = appUserRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(appUser);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
