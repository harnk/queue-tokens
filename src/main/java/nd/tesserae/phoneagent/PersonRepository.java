package nd.tesserae.phoneagent;

import nd.tesserae.phoneagent.entities.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dscottnull on 7/17/18.
 */

public interface PersonRepository extends CrudRepository<Person, String> {

}
