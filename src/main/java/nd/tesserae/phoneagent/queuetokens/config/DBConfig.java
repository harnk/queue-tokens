package nd.tesserae.phoneagent.queuetokens.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by dscottnull on 7/17/18.
 */

@Configuration
public class DBConfig {

    @Value("${source_db_path}")
    private String sourceDatabasePath;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        // file located in dnull@tesserae-phoneagent:/var/www/phone-agent-server/data

        dataSourceBuilder.url("jdbc:sqlite:"+sourceDatabasePath+"/studentlife.db");
        return dataSourceBuilder.build();
    }

}
