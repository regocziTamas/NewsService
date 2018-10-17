package com.codecool.newsservice;

import com.codecool.newsservice.model.NewsArticle;
import com.codecool.newsservice.model.NewsCategory;
import com.codecool.newsservice.repository.NewsArticleRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class NewsserviceApplication {

    @Autowired
    NewsArticleRepository repository;

    @Autowired
    Util util;

    public static void main(String[] args) {
        SpringApplication.run(NewsserviceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            DateTime today = util.getTodaysDateTime();
            String author = "Regőczi Tamás";

            String title1 = "U.S. Credit Card Giants Flout India’s New Law on Personal Data";
            String summary1 = "As India develops new rules governing the data of its residents, global firms are the first target. Companies say they need more time to comply.";
            String article1 = util.readArticle("article1.txt");
            String link1 = "https://static01.nyt.com/images/2018/10/16/business/16INDIAPAYMENTS01/merlin_142036800_062fe7e9-ad14-4bbc-92dd-9e2afc9da25c-superJumbo.jpg?quality=90&auto=webp";

            NewsArticle newsArticle1 = new NewsArticle(author,today,title1,article1,NewsCategory.TECH,link1,summary1);

            String title2 = "M.I.T. Plans College for Artificial Intelligence, Backed by $1 Billion";
            String summary2 = "The goal, said L. Rafael Reif, the president of M.I.T., is to educate “the bilinguals of the future.” Blackstone’s Steven A. Schwarzman is contributing $350 million.";
            String article2 = util.readArticle("article2.txt");
            String link2 = "https://static01.nyt.com/images/2018/10/16/business/16mit-1/merlin_145234875_ebe023b3-3844-4a57-b2c7-590824893fe7-superJumbo.jpg?quality=90&auto=webp";

            NewsArticle newsArticle2 = new NewsArticle(author,today,title2,article2,NewsCategory.POLITICS,link2,summary2);

            String title3 = "Dodgers fall flat in Game 3 as Brewers regain series lead in NLCS";
            String summary3 = "Los Angeles fails to muster any runs and looks less than sharp defensively in a 4-0 loss.";
            String article3 = util.readArticle("article3.txt");
            String link3 = "https://www.washingtonpost.com/resizer/PFbgu7lpDPOqimiDYF-3Ony5hLs=/1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/L722U2WQ6MI6RDBC7IXPOS6W2Y.jpg";

            NewsArticle newsArticle3 = new NewsArticle(author,today,title3,article3,NewsCategory.SPORT,link3,summary3);

            /*System.out.println(newsArticle1);*/

            repository.save(newsArticle1);
            repository.save(newsArticle2);
            repository.save(newsArticle3);

        };
    }
}
