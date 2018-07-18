package nd.tesserae.phoneagent.config;

/**
 * Created by dscottnull on 7/17/18.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitializeConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS UserLogin");
            statement.executeUpdate(
                    "CREATE TABLE UserLogin(" +
                            "id INTEGER Primary key, " +
                            "userName varchar(30) not null," +
                            "password varchar(30) not null," +
                            "firstName varchar(30) not null, " +
                            "lastName varchar(30) not null," +
                            "email varchar(100) not null," +
                            "mobile varchar(30) not null)"
            );
            statement.executeUpdate(
                    "INSERT INTO UserLogin " +
                            "(userName,password,firstName,lastName,email,mobile) " +
                            "VALUES " + "('bharat0126','dbase123','Bharat','Verma',"
                            + " 'bharatverma2488@gmail.com','8861456151')"
            );
            statement.executeUpdate(
                    "INSERT INTO person " +
                            "(uid,hashed_pass,app_version,bundle_id,system_version,device_info,push_token,is_sandbox,device_bind_at,created_at,file_uploaded_at,os_type,device_session_token) " +
                            "VALUES " + "('bharat012z6','zzx2xzzxx','3.4999','tesserae.phoneagent.zzxx','11.3.1.99','iPhone13,1','36c67b3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4',0,1529596876820,1513632469879,1529597411388,'ios','i0wth0is0going0n')"
            );
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
