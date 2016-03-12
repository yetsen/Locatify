package tr.com.locatify.dao;

/**
 * Created by Yunus on 12-Mar-16.
 */
public interface UserDAO {
    void createUser(String email, String password, String name, String surname);
}
