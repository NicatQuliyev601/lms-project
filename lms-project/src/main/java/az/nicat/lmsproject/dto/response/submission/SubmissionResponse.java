package az.nicat.lmsproject.dto.response.submission;

import az.nicat.lmsproject.dto.response.assignment.AssignmentResponse;
import az.nicat.lmsproject.dto.response.user.UserResponse;
import lombok.Data;

@Data
public class SubmissionResponse {
    private Long id;

    private String content;
    private String link;

    private UserResponse user;
//
    private AssignmentResponse assignment;
//
//    private GradeResponse grade;
}
