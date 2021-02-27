package br.com.cwi.reset.exemploreset;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")
public class NomeController {

    static String nome = "teste";

    @GetMapping()
    public String getNome() {
        return nome;
    }

    @PutMapping("/{nome}")
    public String mudarNome(@PathVariable("nome") String nome) {
        this.nome = nome;
        return this.nome;
    }

    @DeleteMapping()
    public void deleteNome() {
        nome=null;
    }



}
