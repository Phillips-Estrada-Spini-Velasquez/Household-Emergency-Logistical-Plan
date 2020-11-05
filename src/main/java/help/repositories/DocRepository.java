package help.repositories;

import help.models.Doc;
import help.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocRepository extends JpaRepository<Doc, Long> {

    List<Doc> findAllByOwner(User owner);

    List<Doc> findAllByGroup_Id(long id);
}