package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    // ‼️ ----------------------- FIND ALL --------------------------- //

    // CONSULTA VERSÃO 1 - Método padrão usando o findAll do ElasticsearchRepository
    @Override
    public List<Article> findAllArticles() {
        // NÃO CONSEGUE FAZER ESTE CAST. DÁ ERRO 500
        // return (List<Article>) repository.findAll();

        // PORTANTO:
        // PASSO 1. GERAR UMA LISTA "MANUALMENTE"
        List<Article> list = new ArrayList<>();
        Iterable<Article> result = repository.findAll();

        // FORMA 1 - COM LAMBDA
        //    result.forEach(a -> {
        //       list.add(a);
        //    });


        // FORMA 2 - COM MÉTODO DE REFERÊNCIA
        result.forEach(list::add);

        // PASSO 2. RETORNAR ESSA LISTA
        return list;
    }

    // CONSULTA VERSÃO 2 - Método personalizado no repository
    @Override
    public List<Article> findArticlesPersonalized() {
        return repository.findAllArticlesPersonalized();
    }

    // ----------------------------------------------------------- ‼️ //

    @Override
    public Article updateArticle(Article article) {
        return repository.save(article);
    }

    @Override
    public Page<Article> getPageByTitle(String title, Pageable pg) {
        return repository.findByTitle(title, pg);
    }
}
