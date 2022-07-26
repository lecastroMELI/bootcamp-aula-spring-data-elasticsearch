package dh.meli.spring_elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

// ANOTAÇÃO DE DOCUMENTO DO NoSQL
// ÍNDICE NUM BANCO NOSQL É O NOME DO BANCO
// meli_doc = BD | NOME DA CLASSE É A TABELA
@Document(indexName = "meli_doc")
@Getter @Setter
public class Article {
    @Id
    private int id;

    // INFORMAÇÕES DO CAMPO: nome, tipo
    @Field(name = "title", type = FieldType.Text)
    private String title;

    /* INDICAR QUE O AUTOR VAI SER SALVO JUNTO COM O ARTIGO
    * "type = FieldType.Nested": INDICA QUE É UM CAMPO IMBUTIDO, OU SEJA, QUE VEM DE OUTRA CLASSE
    * "includeInParent = true" : INDICA QUE É PARA INCLUIR DENTRO DO DOCUMENTO, OU SEJA,
    * QUANDO MANDAR GRAVAR O ARTIGO, VAI GRAVAR A LISTA DE AUTORES JUNTO */
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;
}
