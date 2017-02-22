package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kennethkorcal on 2/22/17.
 */

class SearchRequestParams {
    private String q;
    private String from;
    public String getQ() { return q; }
    public void setQ(String q) { this.q = q; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
}

class Article {
    private String title;
    private String createdBy;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @JsonProperty("created_by")
    public String getCreatedBy() { return createdBy; }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}

class Blog {
    private String title;
    Article[] articles;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Article[] getArticles() { return articles; }

    public void setArticles(Article[] articles) { this.articles = articles; }
}

@RestController
public class JsonRequestController {
    @PostMapping("/string")
    public String getJsonStringLiteral(@RequestBody SearchRequestParams data) {
        return "q=" + data.getQ() + " from=" + data.getFrom();
    }

    @PostMapping("/serialize")
    public String getJsonSerializeGson(@RequestBody SearchRequestParams data) {
        return "q=" + data.getQ() + " from=" + data.getFrom();
    }

    @PostMapping("/file")
    public String getJsonNested(@RequestBody Blog blog) {
        return blog.articles[0].getTitle();
    }
}
