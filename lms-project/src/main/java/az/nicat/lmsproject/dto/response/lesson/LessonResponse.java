package az.nicat.lmsproject.dto.response.lesson;

import az.nicat.lmsproject.dto.response.group.GroupResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LessonResponse {
    private Long id;
    private LocalDate date;
    private GroupResponse group;
    private String description;
}
