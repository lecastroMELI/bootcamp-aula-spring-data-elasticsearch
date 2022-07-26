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

// ANOTAÇÃO QUE DIZ AO SPIRNG QUE É UMA CLASSE DE CONFIGURAÇÃO. vale para qualquer configuração do SPRING.
@Configuration
// NECESSÁRIO DEFINIR QUE É PARA O ELASTIC (caminho da pasta onde está o repository)
@EnableElasticsearchRepositories(basePackages = "dh.meli.spring_elastic.repository")
@ComponentScan(basePackages = "dh.meli.spring_elastic")
public class Config {

    @Bean // DEFINE QUE O SPRING É O RESPONSÁVEL PELA MANIPULAÇÃO DESTA CONEXÃO
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            // DEFINE QUAL É O SERVIDOR
            .connectedTo("localhost:9200")
            // USUÁRIO E SENHA (SE TIVER)
            // .withBasicAuth("elastc", "")
            // AJUSTA O TIMEOUT. POR PADRÃO SÃO 5 SEGUNDOS PARA CONECTAR
            .withConnectTimeout(10000)
            .withSocketTimeout(10000)
            .build();

        // RETORNA A CONFIGURAÇÃO DO CLIENTE. ".rest" PARA CONVERTER PARA RestHighLevelClient
        return RestClients.create(clientConfiguration).rest();
    }

    // MÉTODO RESPONSÁVEL POR INFORMAR AO SPRING AS OPERAÇÕES
    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
            return new ElasticsearchRestTemplate(client());
    }
}
