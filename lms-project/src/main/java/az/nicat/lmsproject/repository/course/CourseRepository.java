package az.nicat.lmsproject.repository.course;

import az.nicat.lmsproject.entity.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String courseName);
}
