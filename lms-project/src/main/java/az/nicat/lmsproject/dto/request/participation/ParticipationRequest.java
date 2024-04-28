package az.nicat.lmsproject.dto.request.participation;

import az.nicat.lmsproject.entity.enums.Attendance;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ParticipationRequest {

    private LocalDate lessonDate;
    private Attendance attendance;
}
