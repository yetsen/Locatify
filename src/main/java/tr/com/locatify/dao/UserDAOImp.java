package tr.com.locatify.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import tr.com.locatify.model.GeneralResponse;

import javax.sql.DataSource;

/**
 * Created by Yunus on 12-Mar-16.
 */
public class UserDAOImp extends JdbcDaoSupport implements UserDAO {

    @Autowired
    private DataSource dataSource;

    private String CREATE_USER_SQL="INSERT INTO user(email, password, name, surname, created_at) values(?,?,?,?,now())";

    @Override
    public GeneralResponse createUser(String email, String password, String name, String surname) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        GeneralResponse response = new GeneralResponse();
        Object [] args = {email, password, name, surname};
        int result = jdbcTemplate.update(CREATE_USER_SQL, args);
        if (result == 1) {
            response.setDesc("İşlem Başarı ile gerçekleşti");
            response.setStatus("SUCCESS");
            response.setStatusCode(1);
        }else {
            response.setDesc("İşlem HATALI");
            response.setStatus("ERROR");
            response.setStatusCode(-1);
        }
        return response;
    }
}
