package nd.tesserae.phoneagent.queuetokens;

import nd.tesserae.phoneagent.queuetokens.entities.Person;
import nd.tesserae.phoneagent.queuetokens.service.PersonService;
import nd.tesserae.phoneagent.queuetokens.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dscottnull on 7/23/18.
 */

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonService personService;

    @Autowired
    private PushService pushService;

    // Executes every 10 minutes (600,000) by default
    @Scheduled(fixedDelayString = "${interval_time_ms:600000}")
    public void doMainLoop() {
        logger.info("MAIN LOOP IS WORKING ");
        List<Person> persons = new ArrayList<>();
        persons = personService.getAllPersonsWithPushTokensAndOsType("ios");
        logger.info("We found "+ persons.size()+" persons with push tokens and os type ios");

        for (Person person : persons) {
            if (person.isSandbox()){
                logger.info("token: "+person.getPushToken()+" is_sandbox: " + person.isSandbox());
                // Insert a record into push_queue_sandbox table

            } else {
                // Insert a record into push_queue_prod table
                pushService.addPersonToPushQueue(person);
            }
        }

    }

}
