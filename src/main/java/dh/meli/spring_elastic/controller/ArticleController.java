package dh.meli.spring_elastic.controller;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @PostMapping
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        return ResponseEntity.ok(service.save(article));
    }
}
