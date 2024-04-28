package az.nicat.lmsproject.controller.auth;

import az.nicat.lmsproject.dto.request.login.LoginRequest;
import az.nicat.lmsproject.dto.request.password.ChangePasswordRequest;
import az.nicat.lmsproject.dto.request.signup.SignUpRequest;
import az.nicat.lmsproject.dto.response.jwt.Response;
import az.nicat.lmsproject.dto.response.user.UserResponse;
import az.nicat.lmsproject.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Response> registerUser(@RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);

    }

    @PostMapping("/signin")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }

    @PostMapping("/changePassword/users/{userId}")
    public ResponseEntity<UserResponse> changePassword(@PathVariable Long userId,
                                                       @RequestBody ChangePasswordRequest request) {
        return authService.changePassword(userId, request);
    }
}
