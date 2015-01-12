import hello.CurrencyAPIUpsertResponse1;
import hello.ExternalAPIObject;
import hello.Product;
import hello.ProductResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;
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
        System.out.println("============ PORT " + System.getenv("PORT"));
        System.out.println("============ server.port " + System.getenv("server.port"));
        SpringApplication.run(SampleController.class, args);
    }

    static{
        Map<String, String> env = new HashMap<String, String>();
        env.put("server.port",System.getenv("PORT"));

        setEnv(env);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected static void setEnv(Map<String, String> newenv) {
        try {
            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
            theEnvironmentField.setAccessible(true);

            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
            env.putAll(newenv);

            Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
            theCaseInsensitiveEnvironmentField.setAccessible(true);

            Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
            cienv.putAll(newenv);
        } catch (NoSuchFieldException e) {
            try {
                Class[] classes = Collections.class.getDeclaredClasses();
                Map<String, String> env = System.getenv();
                for (Class cl : classes) {
                    if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
                        Field field = cl.getDeclaredField("m");
                        field.setAccessible(true);
                        Object obj = field.get(env);
                        Map<String, String> map = (Map<String, String>) obj;
                        map.clear();
                        map.putAll(newenv);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}