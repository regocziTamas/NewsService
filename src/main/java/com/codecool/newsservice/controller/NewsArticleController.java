package com.codecool.newsservice.controller;

import com.codecool.newsservice.Util;
import com.codecool.newsservice.model.NewsArticle;
import com.codecool.newsservice.model.NewsCategory;
import com.codecool.newsservice.repository.NewsArticleRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RestController
public class NewsArticleController {

    @Autowired
    NewsArticleRepository newsRepo;

    @Autowired
    Util util;

    @GetMapping("/news/getall")
    public String getAll(){
        List<NewsArticle> list = newsRepo.findAll();

        JsonArray jsonList = new JsonArray();

        for(NewsArticle news: list){
            jsonList.add(news.getJsonObj());
        }
        System.out.println(jsonList);
        return jsonList.toString();
    }

    @GetMapping("/news/date/{year}/{month}/{day}")
    public String getArticlesForDate(@PathVariable int year, @PathVariable int month, @PathVariable int day){
        JsonArray result = util.createJsonArray(newsRepo.getArticlesByDate(year,month,day));
        return result.toString();
    }

    @GetMapping("/news/today")
    public String getTodaysArticles(){
        DateTime today = util.getTodaysDateTime();
        JsonArray result = util.createJsonArray(newsRepo.getArticlesByDate(today.getYear(),today.getMonthOfYear(),today.getDayOfMonth()));
        return result.toString();

    }

    @GetMapping("/news/id/{id}")
    public String getNewsById(@PathVariable Long id){
        JsonObject newsArticle = newsRepo.getById(id).getJsonObj();
        return newsArticle.toString();
    }

    @GetMapping("/news/category/{category}")
    public String getNewsByCategory(@PathVariable String category){
        JsonArray result = util.createJsonArray(newsRepo.getByCategory(NewsCategory.valueOf(category.toUpperCase())));
        return result.toString();
    }

    @GetMapping("/news/randomthree")
    public String getRecentNews(){
        DateTime today = util.getTodaysDateTime();
        List<NewsArticle> todaysArticles = newsRepo.getArticlesByDate(today.getYear(),today.getMonthOfYear(),today.getDayOfMonth());
        Collections.shuffle(todaysArticles);
        JsonArray resultJsonArray = new JsonArray();
        resultJsonArray.add(todaysArticles.get(1).getJsonObj());
        resultJsonArray.add(todaysArticles.get(2).getJsonObj());
        resultJsonArray.add(todaysArticles.get(3).getJsonObj());
        return resultJsonArray.toString();
    }

    @GetMapping("/news/main")
    public String getMainArticle(){
        JsonObject obj = newsRepo.getById(12L).getJsonObj();
        return obj.toString();
    }

    @GetMapping("/news/latestthree")
    public String getLatestThreeArticle(){
        JsonArray result = util.createJsonArray(newsRepo.getLatestThree(PageRequest.of(0,3)));
        return result.toString();
    }


}
