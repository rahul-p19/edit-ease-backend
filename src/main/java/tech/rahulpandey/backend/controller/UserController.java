package tech.rahulpandey.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.rahulpandey.backend.model.AuthResponse;
import tech.rahulpandey.backend.model.Users;
import tech.rahulpandey.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "User Authentication APIs", description = "Login and Register.")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody Users user) {
        AuthResponse res = userService.register(user);
        if(!res.getOk()) return ResponseEntity.badRequest().body(res);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody Users user) {
        AuthResponse res = userService.verify(user);
        if(res == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
