package dh.meli.spring_elastic.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

// ANOTAÇÃO QUE DIZ AO SPRING QUE É UMA CLASSE DE CONFIGURAÇÃO. (Vale para qualquer configuração do SPRING)
@Configuration
// ANOTAÇÃO QUE DEFINE O REPOSITÓRIO QUE O ELASTIC DEVERÁ USAR (caminho da pasta onde está o repository)
@EnableElasticsearchRepositories(basePackages = "dh.meli.spring_elastic.repository")
@ComponentScan(basePackages = "dh.meli.spring_elastic")
public class Config {

    /* Anotação que usamos para indicar ao Spring que o método retornará um objeto a ser
    * registrado como um Bean de contexto de aplicação. Ou seja:
    * DEFINE QUE O SPRING É O RESPONSÁVEL PELA MANIPULAÇÃO DESTA CONEXÃO */
    @Bean
    /* É um client REST de alto nível para consumir Elasticsearch de Java. Usamos para registrar no Spring a
    * configuração da conexão com a API Elasticsearch Rest. Também usado para operações CRUD no Elasticsearch */
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            // DEFINE QUAL É O SERVIDOR
            .connectedTo("localhost:9200")
            // DEFINE USUÁRIO E SENHA (SE TIVER)
            // .withBasicAuth("elastc", "")
            // AJUSTA O TIMEOUT. POR PADRÃO SÃO 5 SEGUNDOS PARA CONECTAR
            .withConnectTimeout(10000)
            .withSocketTimeout(10000)
            .build();

        // RETORNA A CONFIGURAÇÃO DO CLIENTE. ".rest" PARA CONVERTER PARA RestHighLevelClient
        return RestClients.create(clientConfiguration).rest();
    }

    /* ElasticSearchOperations será responsável por executar as operações no servidor
    * Elasticsearch e, neste caso, usará um ElasticsearchRestTemplate. */
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
            return new ElasticsearchRestTemplate(client());
    }
}
