package dh.meli.spring_elastic.repository;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

// ESTE REPOSITORY FOI DEFINIDO NA CONEXÃO COMO O REPOSITÓRIO PADRÃO
// A INTERFACE EXTENDE DE ElasticsearchRepository QUE RECEBE A "CLASSE" E O "TIPO DA CHAVE ID"
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
    /*
    * QUERY - INTERAGINDO DIRETAMENTE COM O ELASTIC
    * source: https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl-query-string-query.html
    *
    * match-all: SIGNIFICA DEVE DAR MATCH EM TUDO, OU SEJA, TRAZ TUDO QUE COMBINA COM OS CRITÉRIOS DENTRO DAS {}
    * {} : VAZIO, SIGNIFICA TRAGA TUDO
    *
    * */
    @Query("{ \"match_all\": {} }")
    List<Article> findAllArticlesPersonalized();

    /*
    * CONSULTA POR PAGINAÇÃO
    * OS RETORNOS SERÃO REPASSADOS DE FORMA FRACIONADA, OU SEJA, NÃO VIRÃO TODOS OS REGISTROS
    * DE UMA SÓ VEZ, VIRÃO DE ACORDO COM A CONFIGURAÇÃO, EX. 10 EM 10, 20 EM 20 E ETC.
    *
    * AO TRABALHAR COM PAGINAÇÃO, É NECESSÁRIO INFORMAR NO MÉTODO COMO SEGUNDO PARÂMETRO UM PAGEABLE,
    * ELE QUE TERÁ AS PÁGINAS.
    *
    * PORTANTO O MÉTODO FICOU ASSIM:
    * Consultar pelo título:
    * - primeiro parâmentro ("match": title) e o texto que será usado é o que vai como primeiro parâmetro
    * - segundo parâmetro (pg)
    *
    * ElasticsearchRepository TEM POR HERANÇA O PAGEABLE
    *
    * É POSSÍVEL ENVIAR PARÂMETROS PELA URL QUE SERÃO INTERPRETADOS PELA A APLICAÇÃO
    * POR EXEMPLO, PAGE NUMBER É O NÚMERO DA PÁGINA: (...)?page=1 (VER EXEMPLO NAS ROTAS DO POSTMAN)
    */
    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    Page<Article> findByTitle(String title, Pageable pg);
}
