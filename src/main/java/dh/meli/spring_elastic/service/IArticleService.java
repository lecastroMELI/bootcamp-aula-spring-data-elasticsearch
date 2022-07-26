package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticleService {
    // POR PADRÃO, TODOS OS MÉTODOS DEFINIDOS NA INTERFACE SÃO PÚBLICOS. PORTANTO NÃO É NECESSÁRIO INFORMAR
    Article save(Article article);
    Article findById(int id);
    String deleteById(int id);
    List<Article> findAllArticles();
    List<Article> findArticlesPersonalized();
    Article updateArticle(Article article);
    Page<Article> getPageByTitle(String title, Pageable pg);
}
