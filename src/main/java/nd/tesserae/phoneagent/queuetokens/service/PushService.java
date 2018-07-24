package nd.tesserae.phoneagent.queuetokens.service;

import nd.tesserae.phoneagent.queuetokens.PushRepository;
import nd.tesserae.phoneagent.queuetokens.entities.Person;
import nd.tesserae.phoneagent.queuetokens.entities.Push;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

/**
 * Created by dscottnull on 7/23/18.
 */

@Service
public class PushService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PushRepository pushRepository;

    public void addPush(Push push){
        pushRepository.save(push);
    }

    public void addPersonToPushQueue(Person person){
        Push push = new Push();
        push.setDeviceToken(person.getPushToken());
        long now = ZonedDateTime.now().toInstant().toEpochMilli();
        logger.info("time queued: "+now);
        push.setTimeQueued(now);
        push.setPayload("{}");
        // do a save
        pushRepository.save(push);
    }
}