package nd.tesserae.phoneagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/**
 * Created by dscottnull on 7/17/18.
 */


@SpringBootApplication
public class QueueTokensApp {

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(QueueTokensApp.class, args);
    }

}

