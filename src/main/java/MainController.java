import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

/**
 * Author : vinit.bothra
 * Date : 1/12/15-02:27.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan
public class MainController {

    public static void main(String[] args) throws Exception {
        System.out.println("============ PORT " + System.getenv("PORT"));
        System.out.println("============ server.port " + System.getenv("server.port"));
        SpringApplication.run(MainController.class, args);
    }
}