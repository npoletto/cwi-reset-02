package br.com.cwi.reset.exemploreset.service;

import br.com.cwi.reset.exemploreset.domain.Mensagem;
import br.com.cwi.reset.exemploreset.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository repository;

    public List<Mensagem> obterMensagens() {
        return repository.getMensagens();
    }

    public Mensagem criarMensagem(Mensagem mensagem) {
        if(mensagem == null) {

        }
        return null;
    }

}
