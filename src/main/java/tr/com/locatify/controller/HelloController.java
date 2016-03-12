package tr.com.locatify.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yunus on 08-Mar-16.
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "sssdsds";
    }
}
