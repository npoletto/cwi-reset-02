package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.banco.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.banco.Banco;
import br.com.banco.desgraca.domain.conta.decorators.ContaCorrente;
import br.com.banco.desgraca.domain.conta.decorators.ContaDigital;
import br.com.banco.desgraca.domain.conta.decorators.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) {
        /*
            Caros avaliadores, algumas observações:

            OBS 1: Decidi criar uma classe Banco responsável por criar contas bancárias (Factory).
            Sei que o enunciado não exigia esta funcionalidade, por isso neste sistema ela é opcional.
            Caso seja usada, ela verifica o número de conta e impede a abertura de contas com o mesmo número.
            Como sei que irão rodas linhas de teste que já foram desenvolvidas, deixei as classes ContaCorrente,
            ContaDigital e ContaPoupanca com seus construtores públicos. Porém na minha proposta o ideal seria
            que fossem protegidas, e apenas a classe Banco pudesse instanciá-las, conforme ocorre no mundo real, bancos
            abrem contas solicitadas por clientes.
            Mas é apenas uma proposta, o código deverá rodar sem a utilização da classe Banco, da mesma forma.

            OBS 2: Optei pelo uso de Decorators para diferenciar os tipos de conta. Cada um implementa ContaBancaria e
            estende ContaGenerica, adicionando apenas as regras do enunciado (taxas, valor saque, e etc).
            Desta forma evito ter que colocar as regras em cada classe de tipo de conta.

         */


        try {

            Banco bancoDoBrasil = new Banco(InstituicaoBancaria.BANCO_DO_BRASIL);
            Banco itau = new Banco(InstituicaoBancaria.ITAU);
            Banco caixa = new Banco(InstituicaoBancaria.CAIXA);
            Banco bradesco = new Banco(InstituicaoBancaria.BRADESCO);
            Banco nubank = new Banco(InstituicaoBancaria.NUBANK);

            ContaCorrente conta1 = itau.abreContaCorrente(1001);
            ContaDigital conta2 = nubank.abreContaDigital(1);
            ContaPoupanca conta3 = bancoDoBrasil.abreContaPoupanca(120);
            ContaPoupanca conta4 = bancoDoBrasil.abreContaPoupanca(121);

            conta3.depositar(62.3);
            conta3.sacar(50.9);
            conta3.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2020, 7, 6));
            conta2.depositar(100.0);
            conta2.transferir(12.10, conta3);

            conta2.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));
            conta3.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));
            conta3.transferir(22.00, conta2);

            conta2.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));
            conta3.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));

            conta4.depositar(100.0);
            conta4.transferir(50.0, conta3);

            conta3.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));
            conta4.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
