package az.nicat.lmsproject.dto.response.participation;

import az.nicat.lmsproject.dto.response.lesson.LessonResponse;
import az.nicat.lmsproject.dto.response.user.UserResponse;
import az.nicat.lmsproject.entity.enums.Attendance;
import lombok.Data;

@Data
public class ParticipationResponse {
    private Long id;

//    private LocalDate lessonDate;
    private Attendance attendance;
    private double percentage;
    private LessonResponse lesson;
    private UserResponse user;
}
