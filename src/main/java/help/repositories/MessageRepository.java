package help.repositories;

import help.models.Group;
import help.models.Message;
import help.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
//    List<Message> findAllByGroup_Id(long groupId);

}
