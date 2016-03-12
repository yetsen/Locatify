package tr.com.locatify.dao;

import tr.com.locatify.model.GeneralResponse;

/**
 * Created by Yunus on 12-Mar-16.
 */
public interface UserDAO {
    GeneralResponse createUser(String email, String password, String name, String surname);
}
