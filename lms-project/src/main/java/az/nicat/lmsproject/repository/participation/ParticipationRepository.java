package az.nicat.lmsproject.repository.participation;

import az.nicat.lmsproject.entity.participation.Participation;
import az.nicat.lmsproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    List<Participation> findByUser(User student);
    List<Participation> findByUserIdAndLessonDate(Long user_id, LocalDate lessonDate);
    List<Participation> findByGroupId(Long groupId);


}
