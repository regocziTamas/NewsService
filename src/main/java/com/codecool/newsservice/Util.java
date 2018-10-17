package com.codecool.newsservice;

import com.codecool.newsservice.model.NewsArticle;
import com.google.gson.JsonArray;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class Util {

    public JsonArray createJsonArray(List<NewsArticle> list){

        JsonArray arr = new JsonArray();

        for(NewsArticle obj: list){
            arr.add(obj.getJsonObj());
        }

        return arr;
    }

    public DateTime getTodaysDateTime(){
        return new DateTime();
    }

    public String readArticle(String filename){
        File file = new File("src/main/resources/static/" + filename);
        StringBuilder stringBuilder = new StringBuilder();

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                stringBuilder.append(sc.nextLine());
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();


    }


}