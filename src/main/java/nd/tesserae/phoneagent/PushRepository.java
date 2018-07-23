package nd.tesserae.phoneagent;

import nd.tesserae.phoneagent.entities.Push;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dscottnull on 7/23/18.
 */

public interface PushRepository extends CrudRepository<Push, String>{
//    List<Push> findPushesByDeviceToken();
}
