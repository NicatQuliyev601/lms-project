package az.nicat.lmsproject.dto.response.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponse {
    private Long id;

    private String name;

//    private List<User> user = new ArrayList<>();
//
//    private List<Material> materials = new ArrayList<>();
//
//    private List<Assignment> assignments;
}
