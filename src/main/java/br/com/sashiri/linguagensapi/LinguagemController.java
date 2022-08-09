package br.com.sashiri.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Para aplicação entender que esse é um controlador tenho que usar essa anotação rest.
@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository repositorio;

    //Faz o mapeamento da lista e retorna na url ./linguagens  
    @GetMapping(value="/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        return linguagens;
    }

    @PostMapping(value="/linguagens")
    //RequestBody serve para indicar que estou passando a linguagem no corpo da requisição
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }
}
