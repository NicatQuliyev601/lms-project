package az.nicat.lmsproject.dto.response.participation;

import az.nicat.lmsproject.dto.response.lesson.LessonResponse;
import lombok.Data;

@Data
public class AttendanceDetails {
    private boolean attendance;
    private LessonResponse lesson;
}
