package tr.com.locatify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.locatify.dao.UserDAO;
import tr.com.locatify.model.GeneralResponse;
import tr.com.locatify.model.User;

/**
 * Created by Yunus on 12-Mar-16.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public GeneralResponse createUser(@RequestBody User user) {
        return userDAO.createUser(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());
    }
}
