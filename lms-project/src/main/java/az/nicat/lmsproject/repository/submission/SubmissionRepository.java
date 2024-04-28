package az.nicat.lmsproject.repository.submission;

import az.nicat.lmsproject.entity.assignment.Assignment;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.submission.Submission;
import az.nicat.lmsproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    List<Submission> findByAssignmentAndGroup(Assignment assignment, Group group);

    List<Submission> findByAssignmentAndGroupAndUser(Assignment assignment, Group group, User user);

}
