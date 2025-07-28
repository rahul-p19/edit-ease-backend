package tech.rahulpandey.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.rahulpandey.backend.model.AuthResponse;
import tech.rahulpandey.backend.model.MailList;
import tech.rahulpandey.backend.model.Users;
import tech.rahulpandey.backend.repository.MailListRepository;
import tech.rahulpandey.backend.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authManager;

    private final JwtService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final MailListRepository mailListRepository;

    public UserService(UserRepository userRepository, AuthenticationManager authManager, JwtService jwtService, MailListRepository mailListRepository) {
        this.userRepository = userRepository;
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.mailListRepository = mailListRepository;
    }

    public AuthResponse register(Users user){
        MailList mailList = mailListRepository.findByEmail(user.getEmail());
        if(mailList == null) return new AuthResponse(false, "Email not approved");

        Users existingEmailUser = userRepository.findByEmail(user.getEmail());

        if(existingEmailUser != null) return new AuthResponse(false, "Email already exists");

        String role = mailList.getRole();
        String slug = mailList.getEventSlug();
        String token = jwtService.generateToken(user.getEmail());
        user.setRoles(List.of(role));
        user.setEventSlug(slug);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return new AuthResponse(token,role,slug,true);
    }

    public AuthResponse verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        if(authentication.isAuthenticated()){
            String token = jwtService.generateToken(user.getEmail());
            Users authenticatedUser = userRepository.findByEmail(user.getEmail());
            String slug = authenticatedUser.getEventSlug();
            String role = authenticatedUser.getRoles().iterator().next();
            return new AuthResponse(token,role,slug,true);
        }

        return null;
    }
}
