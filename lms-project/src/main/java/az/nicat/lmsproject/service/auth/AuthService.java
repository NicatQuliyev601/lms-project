package az.nicat.lmsproject.service.auth;

import az.nicat.lmsproject.dto.request.login.LoginRequest;
import az.nicat.lmsproject.dto.request.password.ChangePasswordRequest;
import az.nicat.lmsproject.dto.request.signup.SignUpRequest;
import az.nicat.lmsproject.dto.response.group.GroupResponse;
import az.nicat.lmsproject.dto.response.jwt.Response;
import az.nicat.lmsproject.dto.response.user.UserResponse;
import az.nicat.lmsproject.entity.authority.Authority;
import az.nicat.lmsproject.entity.enums.MessageStatus;
import az.nicat.lmsproject.entity.enums.UserAuthority;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.user.User;
import az.nicat.lmsproject.exception.email.EmailExistException;
import az.nicat.lmsproject.exception.handler.ErrorCodes;
import az.nicat.lmsproject.exception.password.InvalidPasswordException;
import az.nicat.lmsproject.exception.users.UserNameExistException;
import az.nicat.lmsproject.exception.users.UserNotFoundException;
import az.nicat.lmsproject.repository.authority.AuthorityRepository;
import az.nicat.lmsproject.repository.user.UserRepository;
import az.nicat.lmsproject.security.jwt.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public ResponseEntity<Response> registerUser(SignUpRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EmailExistException(ErrorCodes.EMAIL_ALREADY_EXIST);
        }

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new UserNameExistException(ErrorCodes.USERNAME_ALREADY_EXIST);
        }

        Authority userAuthority = authorityRepository.findByAuthority(UserAuthority.ADMIN)
                .orElseGet(() -> {
                    Authority authority = new Authority();
                    authority.setAuthority(UserAuthority.ADMIN);
                    return authorityRepository.save(authority);
                });


        User user = User.builder()
                .authorities(List.of(userAuthority))
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .password(signUpRequest.getPassword())
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .build();

        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

//        emailService.sendMail(signUpRequest.getEmail(),
//                "Confirmation",
//                "http://localhost:8080/api/auth/confirmation?confirmationToken=" + confirmationToken);

        return ResponseEntity.ok(Response
                .builder()
                .jwt(jwtService.issueToken(user))
                .build());

    }

    @Transactional
    public ResponseEntity<Response> loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException(ErrorCodes.USER_NOT_FOUND));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException(ErrorCodes.INVALID_PASSWORD);
        }

        user.setStatus(MessageStatus.ONLINE); // Update user's status to online

        GroupResponse groupResponse = null;
        Group group = user.getGroup();
        if (group != null) {
            groupResponse = GroupResponse.builder()
                    .id(group.getId())
                    .name(group.getName())
                    .build();
        }

        return ResponseEntity.ok(Response.builder()
                .jwt(jwtService.issueToken(user))
                .id(user.getId())
                .status(user.getStatus()) // Return the updated status
                .authorities(user.getAuthorities())
                .group(groupResponse)
                .build());
    }


    public ResponseEntity<UserResponse> changePassword(Long userId, ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorCodes.USER_NOT_FOUND));

        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException(ErrorCodes.INVALID_PASSWORD);
        }

        String encodedNewPassword = passwordEncoder.encode(changePasswordRequest.getNewPassword());
        user.setPassword(encodedNewPassword);
        user.setPasswordChanged(true); // Set passwordChanged to true
        userRepository.save(user);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setAuthorities(user.getAuthorities());
        userResponse.setPasswordChanged(user.getPasswordChanged());
        userResponse.setGroup(userResponse.getGroup());

        return ResponseEntity.ok(userResponse);
    }

}
