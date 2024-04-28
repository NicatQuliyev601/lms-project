package az.nicat.lmsproject.repository.user;

import az.nicat.lmsproject.entity.enums.MessageStatus;
import az.nicat.lmsproject.entity.group.Group;
import az.nicat.lmsproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);


    List<User> findByGroupId(Long groupId);

    List<User> findAllByStatus(MessageStatus status);
    Optional<User> findByUsername(String username);

    List<User> findByGroup(Group group);



}
