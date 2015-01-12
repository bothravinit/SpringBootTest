import hello.CurrencyAPIUpsertResponse1;
import hello.ExternalAPIObject;
import hello.Product;
import hello.ProductResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping(method = RequestMethod.POST, value="/currency_api/exchange-rate/upsert")
    @ResponseBody
    CurrencyAPIUpsertResponse1 home(@RequestBody ExternalAPIObject apiObject ) {
        CurrencyAPIUpsertResponse1 c = new CurrencyAPIUpsertResponse1();
        c.setStatus(200);
        Logger l = Logger.getLogger(SampleController.class.getName());
        final ArrayList<String> list = new ArrayList<String>();
        l.info("apiObject : " + apiObject.getBase());
        list.add("success");
        c.setMessages(list);
        System.out.println(apiObject.getBase());
        System.out.println(apiObject.getRates());
        System.out.println("==========================================================================================");
//        return "Hello World!";

        return c;
    }

    @RequestMapping(method = RequestMethod.GET, value="/products")
    @ResponseBody
    ProductResponse home(@RequestParam(value = "categoryId") String categoryId) {
        ProductResponse productResponse = new ProductResponse();
        Product product = new Product("name", "title", "description", "categoryId", 123);

        productResponse.setProducts(Arrays.asList(product));
        System.out.println("==========================================================================================");
        return productResponse;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}