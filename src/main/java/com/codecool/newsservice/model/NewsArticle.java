package com.codecool.newsservice.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
public class NewsArticle {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private DateTime date;
    private String title;
    @Lob
    private String article;
    private String imgUrl;
    private String summary;
    @Enumerated(EnumType.STRING)
    private NewsCategory category;
    public int year;
    public int month;
    public int day;

    public NewsArticle(String author, DateTime date, String title, String article, NewsCategory category, String imgUrl, String summary) {
        this.author = author;
        this.date = date;
        this.title = title;
        this.article = article;
        this.category = category;
        this.imgUrl = imgUrl;
        this.summary = summary;
        year = date.getYear();
        month = date.getMonthOfYear();
        day = date.getDayOfMonth();
    }

    public NewsArticle() {

    }

    public JsonObject getJsonObj() {
        JsonObject temp = new JsonObject();
        temp.addProperty("id", id);
        temp.addProperty("author", author);
        temp.addProperty("date", date.toString());
        temp.addProperty("title", title);
        temp.addProperty("article", article);
        temp.addProperty("imgurl", imgUrl);
        temp.addProperty("category", category.toString());
        temp.addProperty("summary", summary);

        return temp;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Author: " + author + " Date: " + date + " Title: " + title + " Article: " + article + " Category: " + category;
    }

    public DateTime getDate() {
        return date;
    }

}
