package com.cbf.brasileirao.desgraca.mapper;

import com.cbf.brasileirao.desgraca.entity.CampeonatoEntity;
import com.cbf.brasileirao.desgraca.entity.JogadorEntity;
import com.cbf.brasileirao.desgraca.entity.TimeEntity;
import com.cbf.brasileirao.desgraca.request.CampeonatoRequest;
import com.cbf.brasileirao.desgraca.request.CriarTimeRequest;
import com.cbf.brasileirao.desgraca.request.JogadorRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CriarTimeMapper {

    public TimeEntity map(CriarTimeRequest request) {
        List<JogadorEntity> jogadores = mapListaJogadores(request);
        List<CampeonatoEntity> campeonatos = mapListaCampeonatos(request);
        TimeEntity time = new TimeEntity(request.getTime().getNome(),
                request.getTime().getDataFundacao(), request.getTime().getCaixa(), request.getTime().getTecnico().getNome(),
                jogadores, campeonatos);
        return time;
    }

    private List<CampeonatoEntity> mapListaCampeonatos(CriarTimeRequest request) {
        List<CampeonatoEntity> campeonatos = new ArrayList<>();
        for (CampeonatoRequest campeonatoRequest : request.getTime().getCampeonatos()) {
            campeonatos.add(mapCampeonato(campeonatoRequest));
        }
        return campeonatos;
    }

    private List<JogadorEntity> mapListaJogadores(CriarTimeRequest request) {
        List<JogadorEntity> jogadores = new ArrayList<>();
        for (JogadorRequest jogadorRequest : request.getTime().getJogadores()) {
            jogadores.add(mapJogador(jogadorRequest));
        }
        return jogadores;
    }

    private JogadorEntity mapJogador(JogadorRequest jogadorRequest) {
        return new JogadorEntity(jogadorRequest.getId(), jogadorRequest.getNome(),
                jogadorRequest.getPosicao(), jogadorRequest.getTipo());
    }

    private CampeonatoEntity mapCampeonato(CampeonatoRequest campeonatoRequest) {
        return new CampeonatoEntity(campeonatoRequest.getId(), campeonatoRequest.getNome(),
                campeonatoRequest.getTipo(), campeonatoRequest.getNivel());
    }
}
