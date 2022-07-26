package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements IArticleService {

    // INJEÇÃO DE DEPENDÊNCIA POR ATRIBUTO
    @Autowired
    private ArticleRepository repository;

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }

    @Override
    public Article findById(int id) {
        return repository.findById(id).get();
    }
}
