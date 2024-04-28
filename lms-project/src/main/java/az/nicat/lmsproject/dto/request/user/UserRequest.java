package az.nicat.lmsproject.dto.request.user;

import az.nicat.lmsproject.entity.enums.UserAuthority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private UserAuthority authority;
}
