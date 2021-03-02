package br.com.cwi.resetflix.web;

import br.com.cwi.resetflix.request.CriarDiretorRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;
import br.com.cwi.resetflix.service.DiretoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretoresController implements DiretoresContract {

    @Autowired
    private DiretoresService diretoresService;

    @Override
    @GetMapping
    public List<DiretoresResponse> getDiretores() {
        DiretoresService service = new DiretoresService();
      //  diretoresService
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesDiretorResponse getDiretorById(Long id) {
        return null;
    }

    @Override
    @PostMapping
    public Long criarDiretor(CriarDiretorRequest request) {
        return null;
    }
}
