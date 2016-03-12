package tr.com.locatify.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import tr.com.locatify.model.GeneralResponse;
import tr.com.locatify.model.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yunus on 12-Mar-16.
 */
public class CurseDAOImp extends JdbcDaoSupport implements CurseDAO {

    private String insertMessageSQL = "INSERT INTO curse" +
            "(username, latitude, longitude, message) VALUES (?,?,?,?)";

    private String getMessageSQL = "select * from curse where latitude BETWEEN ? - 1 and ? + 1  and longitude BETWEEN ? - 1 and ? + 1";

    @Override
    public GeneralResponse insertMessage(Object [] args) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        int result = jdbcTemplate.update(insertMessageSQL, args);
        GeneralResponse response = new GeneralResponse();
        if(result == 1) {
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

    @Override
    public List<Message> getMessage(Object[] args) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        return jdbcTemplate.query(getMessageSQL, args, new RowMapper<Message>() {
            @Override
            public Message mapRow(ResultSet resultSet, int i) throws SQLException {
                Message message = new Message();
                message.setMessage(resultSet.getString("message"));
                message.setLatitude(Double.parseDouble(resultSet.getString("latitude")));
                message.setLongitude(Double.parseDouble(resultSet.getString("longitude")));
                message.setUsername(resultSet.getString("username"));
                return message;
            }
        });
    }
}
