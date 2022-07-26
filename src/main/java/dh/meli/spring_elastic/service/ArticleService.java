package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String deleteById(int id) {
        repository.deleteById(id);
        return "Artigo " + id +" Removido Com Sucesso ✅";
    }

    // CONSULTA VERSÃO 1
    /*@Override
    public List<Article> findAllArticles() {
        // NÃO CONSEGUE FAZER ESTE CAST. DÁ ERRO 500
        // return (List<Article>) repository.findAll();

        // PORTANTO: GERAR UMA LISTA "MANUALMENTE"
        List<Article> list = new ArrayList<>();
        Iterable<Article> result = repository.findAll();

        *//* FORMA 1
            result.forEach(a -> {
                list.add(a);
            });
        *//*

        *//* FORMA 2 - FAZ O MESMO QUE A FORMA 1 *//*
        result.forEach(list::add);

        // E RETORNA A LISTA
        return list;
    }*/

    // CONSULTA VERSÃO 2
    @Override
    public List<Article> findAllArticles() {
        return repository.findAllArticles();
    }

        @Override
    public Article updateArticle(Article article) {
        return repository.save(article);
    }
}
