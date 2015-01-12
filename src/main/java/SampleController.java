import com.demo.Product;
import com.demo.ProductResponse;
import hello.entities.BaseResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Author : vinit.bothra
 * Date : 1/12/15-02:27.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {


    @RequestMapping(method = RequestMethod.POST, value="/products")
    @ResponseBody
    BaseResponse home(@RequestBody ProductResponse apiObject ) {
        BaseResponse c = new BaseResponse();
//        c.setStatus(200);
        Logger l = Logger.getLogger(SampleController.class.getName());
        final ArrayList<String> list = new ArrayList<String>();
        System.out.println("==========================================================================================");

        return c;
    }

    @RequestMapping(method = RequestMethod.GET, value="/products")
    @ResponseBody
    private ProductResponse getProductsByCategoryId(@RequestParam(value = "categoryId", required = false) String categoryId) {
        ProductResponse productResponse = new ProductResponse();
        Product product = new Product("name", "title", "description", "categoryId", 123);

        productResponse.setProducts(Arrays.asList(product));
        System.out.println("==========================================================================================");
        return productResponse;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("============ PORT " + System.getenv("PORT"));
        System.out.println("============ server.port " + System.getenv("server.port"));
        SpringApplication.run(SampleController.class, args);
    }
}