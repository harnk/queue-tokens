package nd.tesserae.phoneagent.queuetokens;

import nd.tesserae.phoneagent.queuetokens.entities.Push;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dscottnull on 7/23/18.
 */

public interface PushRepository extends CrudRepository<Push, String>{
//    List<Push> findPushesByDeviceToken();
}
