package com.example.MyOwnMP3.Auth;

import com.example.MyOwnMP3.Auth.Token.ConfirmationToken;
import com.example.MyOwnMP3.Auth.Token.ConfirmationTokenService;
import com.example.MyOwnMP3.Common.Const;
import com.example.MyOwnMP3.Enum.Role;
import com.example.MyOwnMP3.Model.AppUser;
import com.example.MyOwnMP3.Repository.AppUserRepository;
import com.example.MyOwnMP3.Service.AppUserService;
import com.example.MyOwnMP3.Service.JwtService;
import com.example.MyOwnMP3.Validator.EmailValidator;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    MessageSource messageSource;
    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final EmailValidator emailValidator;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    public String RegistrationToken;

    public String register(RegisterRequest request) {

        boolean isValidEmail = emailValidator.patternMatches(request.getEmail(), Const.REGEX_PATTERN);
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        var appUser = new AppUser(request.getFirstname() + request.getLastname(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail(),
                Role.USER);

        RegistrationToken = appUserService.registerNewAccount(appUser);
        System.out.println(RegistrationToken);
        return "";
//        var jwtToken = jwtService.generateToken(appUser);
//        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public ResponseEntity authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
            )
        );
        var appUser = appUserRepository.findByEmail(request.getEmail()).orElseThrow();
        if (appUser.isEnabled()) {
            var jwtToken = jwtService.generateToken(appUser);
            return new ResponseEntity<>(AuthenticationResponse.builder().token(jwtToken).build(), HttpStatus.OK) ;
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public String confirmToken(String token) {
        //TODO update exeption
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());

        return messageSource.getMessage("04", new String[]{}, Locale.getDefault());
    }


}
