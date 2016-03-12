package tr.com.locatify.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 * Created by Yunus on 12-Mar-16.
 */
public class UserDAOImp extends JdbcDaoSupport implements UserDAO {

    @Autowired
    private DataSource dataSource;

    private String CREATE_USER_SQL="INSERT INTO USER(email, password, name, surname, created_at) values(?,?,?,?,now())";

    @Override
    public void createUser(String email, String password, String name, String surname) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        Object [] args = {email, password, name, surname};
        jdbcTemplate.update(CREATE_USER_SQL, args);
    }
}
