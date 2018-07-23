package nd.tesserae.phoneagent.service;

import nd.tesserae.phoneagent.PersonRepository;
import nd.tesserae.phoneagent.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scottnull on 7/18/18.
 */

@Service
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonRepository personRepository;

//    private PushService pushService;
//
//    @Autowired
//    public void setPushService(PushService pushService){
//        this.pushService = pushService;
//    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll()
                .forEach(persons::add);
        return persons;
    }

    public List<Person> getAllPersonsWithPushTokensAndOsType(String os) {
        List<Person> persons = new ArrayList<>();
        persons = personRepository.findPeopleByPushTokenIsNotNullAndOsType(os);
        return persons;
    }

    public Person getPerson(String id) {
        return personRepository.findOne(id);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(String id, Person person) {
        personRepository.save(person);
    }

    public void deletePerson(String id) {
        personRepository.delete(id);
    }


}
