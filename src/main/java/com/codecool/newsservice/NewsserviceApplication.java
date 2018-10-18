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

            String title4 = "Netflix’s new ‘Salt Fat Acid Heat’ is unlike any other food show on TV";
            String summary4 = "Samin Nosrat, the show's star, breaks the mold — and shows us it's okay to make mistakes.";
            String article4 = util.readArticle("article4.txt");
            String link4 = "https://www.washingtonpost.com/resizer/zol1aJbEGFQOuzSPx88Ph4g4v9I=/1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/KSRUBEWKMIZRNDSU4IWXXVP26I.jpg";

            NewsArticle newsArticle4 = new NewsArticle(author,today,title4,article4,NewsCategory.CULTURE,link4,summary4);

            String title5 = "Game of Thrones' Maisie Williams: 'I'm still petrified of my peers";
            String summary5 = "Her role as Arya Stark won her millions of fans but left her bullied at school. Now the 21-year-old is making her stage debut, starring in a Marvel horror – and finally getting her fingernails painted";
            String article5 = util.readArticle("article5.txt");
            String link5 = "https://i.guim.co.uk/img/media/d5dee58db423f37e612b7d339eed545f2ca01f0e/870_341_4942_2967/master/4942.jpg?width=1020&quality=85&auto=format&fit=max&s=d070f1868d75a87ce80937f6c6b366e4";

            NewsArticle newsArticle5 = new NewsArticle(author,today,title5,article5,NewsCategory.CULTURE,link5,summary5);

            String title6 = "Breast enlargement ads shown during Love Island banned by ASA";
            String summary6 = "Ad watchdog found cosmetic surgery was treated in an ‘irresponsible and harmful’ way";
            String article6 = util.readArticle("article6.txt");
            String link6 = "https://i.guim.co.uk/img/media/1edc2a7be55f4cd2b9f77991c5a99f1bcfeca476/1_0_2559_1536/master/2559.jpg?width=620&quality=85&auto=format&fit=max&s=464f129f010488e88c5ac7d4f4d8afb6";

            NewsArticle newsArticle6 = new NewsArticle(author,today,title6,article6,NewsCategory.CULTURE,link6,summary6);

            String title7 = "France add to Germany’s woes as Antoine Griezmann leads comeback win";
            String summary7 = "France 2-1 Germany - Griezmann 62, 80pen; Kroos 14pen";
            String article7 = util.readArticle("article7.txt");
            String link7 = "https://i.guim.co.uk/img/media/d03d10efa91d24ac43f09df5f37efe7c84b360c9/0_0_3500_2101/master/3500.jpg?width=620&quality=85&auto=format&fit=max&s=9f9c7a526d946e149ecc164c16435277";

            NewsArticle newsArticle7 = new NewsArticle(author,today,title7,article7,NewsCategory.SPORT,link7,summary7);

            String title8 = "Bemusement in Crawley over Ronnie O’Sullivan’s ‘hellhole’ comments";
            String summary8 = "Fellow players and staff do not share O’Sullivan’s dim view of the leisure centre that is hosting the English Open, while Barry Hearn has a theory on why the snooker star hit out";
            String article8 = util.readArticle("article8.txt");
            String link8 = "https://i.guim.co.uk/img/media/e679fad7da888316fa40fcb8a55ece6d83e9083c/26_42_6670_4002/master/6670.jpg?width=620&quality=85&auto=format&fit=max&s=a9ddb3811decb9ec856063fad2b56eb9";

            NewsArticle newsArticle8 = new NewsArticle(author,today,title8,article8,NewsCategory.SPORT,link8,summary8);

            String title9 = "Huawei Mate 20 Pro launches with in-screen fingerprint sensor";
            String summary9 = "Feature-packed Android phone is first widely available with scanner embedded in screen alongside 3D face unlocking";
            String article9 = util.readArticle("article9.txt");
            String link9 = "https://i.guim.co.uk/img/media/a2021feeb7d891930a45ab3c700ddde26223a321/1_0_4353_2613/master/4353.jpg?width=620&quality=85&auto=format&fit=max&s=cf98aa9706509d4b572a70b43916c900";

            NewsArticle newsArticle9 = new NewsArticle(author,today,title9,article9,NewsCategory.TECH,link9,summary9);

            String title10 = "Amazon launches water-resistant Kindle Paperwhite";
            String summary10 = "Update of popular e-reader introduces thinner and lighter design, Bluetooth compatibility and audiobook support";
            String article10 = util.readArticle("article10.txt");
            String link10 = "https://i.guim.co.uk/img/media/973cdabede957fd0715c4c82df733ce01ba7f2b7/0_0_1307_784/master/1307.jpg?width=620&quality=85&auto=format&fit=max&s=d0777999c0a9c0dd44322004c751ffd1";

            NewsArticle newsArticle10 = new NewsArticle(author,today,title10,article10,NewsCategory.TECH,link10,summary10);

            String title11 = "Cannabis becomes legal in Canada";
            String summary11 = "Country becomes second and largest with legal national marijuana marketplace";
            String article11 = util.readArticle("article11.txt");
            String link11 = "https://www.vichealth.vic.gov.au/-/media/Images/VicHealth/youthstrategy1200x525.jpg?h=525&la=en&w=1200&hash=A64B03EB9F5FE8EEDF2092A5D00298B696EA2EDF";

            NewsArticle newsArticle11 = new NewsArticle(author,today,title11,article11,NewsCategory.POLITICS,link11,summary11);

            String title12 = "Trump baby blimp to greet commuters over Los Angeles freeways";
            String summary12 = "The giant image of a diaper-clad Trump will appear this weekend in time for Politicon, a star-studded political conference";
            String article12 = util.readArticle("article12.txt");
            String link12 = "https://24.p3k.hu/app/uploads/2018/07/k_epa20180717177-e1532325383861-1024x627.jpg";

            NewsArticle newsArticle12 = new NewsArticle(author,today,title12,article12,NewsCategory.POLITICS,link12,summary12);



            repository.save(newsArticle1);
            repository.save(newsArticle2);
            repository.save(newsArticle3);
            repository.save(newsArticle4);
            repository.save(newsArticle5);
            repository.save(newsArticle6);
            repository.save(newsArticle7);
            repository.save(newsArticle8);
            repository.save(newsArticle9);
            repository.save(newsArticle10);
            repository.save(newsArticle11);
            repository.save(newsArticle12);

        };
    }
}
