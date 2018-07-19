package nd.tesserae.phoneagent;

import nd.tesserae.phoneagent.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dscottnull on 7/17/18.
 */

public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findPeopleByOsType(String os_type);
    List<Person> findPeopleByPushTokenIsNotNull();
    List<Person> findPeopleByPushTokenIsNotNullAndOsType(String os_type);
}
