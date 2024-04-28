package az.nicat.lmsproject.dto.response.assignment;

import az.nicat.lmsproject.dto.response.group.GroupResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssignmentResponse {
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private String submissionRequirements;
    private GroupResponse group;
}
