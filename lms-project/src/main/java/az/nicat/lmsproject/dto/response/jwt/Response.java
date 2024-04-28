package az.nicat.lmsproject.dto.response.jwt;

import az.nicat.lmsproject.dto.response.group.GroupResponse;
import az.nicat.lmsproject.entity.authority.Authority;
import az.nicat.lmsproject.entity.enums.MessageStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
    private Long id;
    String jwt;
    private List<Authority> authorities;
    private GroupResponse group;
    private MessageStatus status;
}
