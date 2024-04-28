package az.nicat.lmsproject.repository.material;

import az.nicat.lmsproject.entity.material.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    Material findByContent(String content);
    List<Material> findByGroupId(Long groupId);
}
