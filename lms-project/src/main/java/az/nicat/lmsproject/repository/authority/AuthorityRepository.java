package az.nicat.lmsproject.repository.authority;

import az.nicat.lmsproject.entity.authority.Authority;
import az.nicat.lmsproject.entity.enums.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByAuthority(UserAuthority userAuthority);
}
