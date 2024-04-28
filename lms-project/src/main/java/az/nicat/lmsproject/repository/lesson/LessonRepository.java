package az.nicat.lmsproject.repository.lesson;

import az.nicat.lmsproject.entity.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByDate(LocalDate date);

}
