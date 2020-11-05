package help.repositories;

import help.models.Document;
import help.models.Group;
import help.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findAllByOwner(User owner);

    List<Document> findAllByGroup_Id(long id);
}