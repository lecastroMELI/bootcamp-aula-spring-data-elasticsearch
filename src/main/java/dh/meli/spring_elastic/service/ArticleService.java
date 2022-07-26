package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // INJEÇÃO DE DEPENDÊNCIA POR CONSTRUTOR: USADA JUNTO COM A PALAVRA 'final' NA DEFINIÇÃO
public class ArticleService implements IArticleService {

    // INJEÇÃO DE DEPENDÊNCIA POR CONSTRUTOR (É IDÊNTICO AO @Autowired ABAIXO)
    // O LOOMBOK GERA UM CONSTRUTOR COM ARGUMENTOS E O SPRING VAI TER QUE GERAR O OBJETO USANDO ESSE CONSTRUTOR
    private final ArticleRepository repository;

    // INJEÇÃO DE DEPENDÊNCIA POR ATRIBUTO
    // @Autowired
    // private ArticleRepository repository;

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }

    @Override
    public Article findById(int id) {
        return repository.findById(id).get();
    }
}
