package hello;

/**
 * Created by vinit.bothra on 6/23/14.
 */

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//        Http
        List<String> hrefs = new ArrayList<String>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = null;
        try {
            forEntity = restTemplate.getForEntity("http://www.ndtv.com/", String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        System.out.println(forEntity.getStatusCode());
        Document parse = Jsoup.parse(forEntity.getBody());

        Elements topnewslisting = parse.select("div.topnewslisting");
        Elements children = topnewslisting.get(0).children().get(0).children();

        Elements topbignews_cont = parse.select("div.topbignews_cont");
        System.out.println("----------div.topbignews_cont-----------");
        for(int i =0 ; i<topbignews_cont.size() ; i++){
            String href = topbignews_cont.get(0).children().get(0).attributes().get("href");
            String src = topbignews_cont.get(0).children().get(0).children().get(0).attributes().get("src");
            hrefs.add(href);
            System.out.println(href);
        }


        System.out.println("----------div.topnewslisting-----------");
        for (int i = 0; i < children.size(); i++) {
            String text = children.get(i).children().get(1).text();
            String image = children.get(i).children().get(0).children().get(0).attributes().get("src");
            String href = children.get(i).children().get(0).attributes().get("href");
            System.out.println(text + ":" + image + ":" + href);
            hrefs.add(href);

        }

        System.out.println("----------div.featurest_listing-----------");
        Elements featurest_listing = parse.select("div.featurest_listing");
        Elements children1 = featurest_listing.get(0).children().get(0).children();
        for(int i =0 ;i < children1.size(); i++){
            String href = featurest_listing.get(0).children().get(0).children().get(i).children().get(0).attributes().get("href");
            hrefs.add(href);
            System.out.println(href);
        }


        Elements only_listing = parse.select("div.topst_listing");
        System.out.println("----------div.topst_listing-----------");
        for (int i = 0; i < only_listing.get(0).children().get(0).children().size(); i++) {
            String href = only_listing.get(0).children().get(0).children().get(i).children().get(0).attributes().get("href");
            hrefs.add(href);
            System.out.println("href : " + href);
        }


        System.out.println(hrefs.size());
        System.out.println(hrefs);

//        only_listing.get(0).children().get(0).children().get(0).children().get(0).attributes().get("href")
//        parse.select("div.");
//        Elements news_cont = parse.getElementsByAttribute("news_cont");
//        Elements news_cont1 = parse.getElementsByAttribute("news_cont");
//        Elements news_cont2 = parse.getElementsByAttribute("news_cont");
//        Elements news_cont3 = parse.getElementsByAttribute("news_cont");
//        parse.getElementById()
    }

}