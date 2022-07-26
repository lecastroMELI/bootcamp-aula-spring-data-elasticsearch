package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;

public interface IArticleService {
    // POR PADRÃO, TODOS OS MÉTODOS DEFINIDOS NA INTERFACE SÃO PÚBLICOS. PORTANTO NÃO É NECESSÁRIO INFORMAR
    Article save(Article article);
    Article findById(int id);
}
