package com.app.courses.auth;

import com.app.courses.config.JwtService;
import com.app.courses.user.Role;
import com.app.courses.user.User;
import com.app.courses.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRegister authregister) {
        System.out.println(authregister);
        var user = User.builder()
                .firstName(authregister.getFirstName())
                .lastName(authregister.getLastName())
                .email(authregister.getEmail()).role(Role.ROLE_USER)
                .password(passwordEncoder.encode(authregister.getPassword())).build();
        userRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwt).user(user).build();

    }

    public AuthResponse login(AuthLogin authLogin) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authLogin.getEmail(),
                authLogin.getPassword()
        ));
        var user = userRepository.findByEmail(authLogin.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwt).user(user).build();
    }
}
