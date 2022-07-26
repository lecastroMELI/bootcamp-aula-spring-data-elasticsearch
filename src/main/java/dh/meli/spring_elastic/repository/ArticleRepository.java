package dh.meli.spring_elastic.repository;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

// JÁ FOI DEFINIDO NA CONEXÃO QUE AQUI ESTÁ MEU REPOSITRY
// RECEBE A CLASSE E O TIPO DA CHAVE ID
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
    /*
    * match-all combinar com todos, traz tudo que combina com os critérios dentro do {}
    * {} vazio = traga tudo
    *
    * INTERAGINDO DIRETAMENTE COM O ELASTIC
    * */
    @Query("{ \"match_all\": {} }")
    List<Article> findAllArticles();
}
