package nd.tesserae.phoneagent;

import nd.tesserae.phoneagent.entities.Person;
import nd.tesserae.phoneagent.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;


/**
 * Created by dscottnull on 7/17/18.
 */


@SpringBootApplication
@EnableScheduling
@PropertySource("file:${user.home}/queuetokens.properties")
public class QueueTokensApp implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${source_db_path}")
    private String sourceDatabase;

    @Value("${mqtt_url}")
    private String mqttURL;

    @Value("${user_name}")
    private String userName;

    private static void confirmPropertiesFileExists() {
        String userHome = System.getProperty("user.home");
        File f = new File(userHome + "/" + "queuetokens.properties");
        if (f.exists()) {
            System.out.println("FOUND Properties File.");
        } else {
            System.out.println("Missing Properties File: " + userHome + "/" + "queuetokens.properties  ... EXITING.");
            System.exit(0);
        }
    }

    public static void main(String[] args){
        confirmPropertiesFileExists();
        SpringApplicationBuilder builder = new SpringApplicationBuilder(QueueTokensApp.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);

    }

    @Override
    public void run(String... strings) throws Exception {
        String userHome = System.getProperty("user.home");
        logger.info("Settings from " + userHome + "/queuetokens.properties ...");
        logger.info("sourceDatabase: " + sourceDatabase);
        logger.info("mqttURL: " + mqttURL);
        logger.info("userName: " + userName);
    }
}

