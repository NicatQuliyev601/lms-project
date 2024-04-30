package az.nicat.lmsproject.dto.response.grade;

import az.nicat.lmsproject.dto.response.submission.SubmissionResponse;
import lombok.Data;

@Data
public class GradeResponse {
    private int score;
    private String feedback;

    private SubmissionResponse submission;
}
