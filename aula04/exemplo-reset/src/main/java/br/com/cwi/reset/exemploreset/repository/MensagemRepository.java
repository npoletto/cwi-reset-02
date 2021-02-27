package br.com.cwi.reset.exemploreset.repository;

import br.com.cwi.reset.exemploreset.domain.Mensagem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MensagemRepository {

    static List<Mensagem> mensagens = new ArrayList<>();

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public Mensagem addMensagem(Mensagem mensagem) {
        return mensagem;
    }


}
