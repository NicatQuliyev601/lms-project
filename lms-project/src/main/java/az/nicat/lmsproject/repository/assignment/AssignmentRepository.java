package az.nicat.lmsproject.repository.assignment;

import az.nicat.lmsproject.entity.assignment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByGroupId(Long groupId);

}
