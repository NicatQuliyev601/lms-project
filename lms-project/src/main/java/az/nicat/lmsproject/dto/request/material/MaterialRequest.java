package az.nicat.lmsproject.dto.request.material;

import lombok.Data;

@Data
public class MaterialRequest {
    private String title;
    private String type;
    private String content;
    private Long groupId;
}
