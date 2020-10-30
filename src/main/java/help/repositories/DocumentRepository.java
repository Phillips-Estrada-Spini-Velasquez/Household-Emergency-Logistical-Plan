package help.repositories;

import help.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Group, Long> {
}
