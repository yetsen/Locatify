package tr.com.locatify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by Yunus on 08-Mar-16.
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {


    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
