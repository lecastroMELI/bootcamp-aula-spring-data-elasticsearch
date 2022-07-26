package dh.meli.spring_elastic.controller;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @PostMapping
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        return ResponseEntity.ok(service.save(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findArticleById(@PathVariable int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping
    public ResponseEntity<List<Article>> findAllArticles() {
        return ResponseEntity.ok(service.findAllArticles());
    }

    @GetMapping("/personalized")
    public ResponseEntity<List<Article>> findAllArticlesPersonalized() {
        return ResponseEntity.ok(service.findArticlesPersonalized());
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        return ResponseEntity.ok(service.updateArticle(article));
    }

    @GetMapping("/title/{title}")
    public Page<Article> getPageByTitle(@PathVariable String title, Pageable pg) {
        return service.getPageByTitle(title, pg);
    }
}
