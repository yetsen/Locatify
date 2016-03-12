package tr.com.locatify.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tr.com.locatify.dao.UserDAO;
import tr.com.locatify.dao.UserDAOImp;

import javax.sql.DataSource;


/**
 * Created by Yunus on 12-Mar-16.
 */
@Configuration
public class DAOConfig {

    @Value("locatify.datasource.driverClassName")
    private String classDriver;

    @Value("locatify.datasource.url")
    private String url;

    @Value("locatify.datasource.username")
    private String username;

    @Value("locatify.datasource.password")
    private String password;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(classDriver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public UserDAO userDAO() {
        UserDAOImp userDAO = new UserDAOImp();
        userDAO.setDataSource(dataSource());
        return userDAO;
    }
}
