package com.codecool.newsservice.repository;

import com.codecool.newsservice.model.NewsArticle;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {

    @Transactional
    @Query("SELECT article from NewsArticle article WHERE article.year = :year AND article.month = :month AND article.day = :day")
    public List<NewsArticle> getArticlesByDate(@Param("year")int year,@Param("month") int month, @Param("day") int day);

    @Transactional
    public NewsArticle getById(Long id);

}
