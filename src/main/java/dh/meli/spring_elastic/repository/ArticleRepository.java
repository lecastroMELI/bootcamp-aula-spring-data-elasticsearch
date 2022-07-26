package dh.meli.spring_elastic.repository;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

// RECEBE A CLASSE E O TIPO DA CHAVE ID
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
}
