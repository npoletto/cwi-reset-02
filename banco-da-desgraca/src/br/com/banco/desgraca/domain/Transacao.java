package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.ContaBancaria;

import java.time.LocalDate;

public class Transacao {
    private LocalDate date;
    private TipoTransacao tipoTransacao;
    private ContaBancaria contaBancaria;
}
