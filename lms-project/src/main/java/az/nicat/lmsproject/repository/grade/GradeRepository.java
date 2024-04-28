package az.nicat.lmsproject.repository.grade;

import az.nicat.lmsproject.entity.grade.Grade;
import az.nicat.lmsproject.entity.submission.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    Grade findBySubmission(Submission submission);
}
