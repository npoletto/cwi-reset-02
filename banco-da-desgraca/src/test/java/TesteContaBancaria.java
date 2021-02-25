import br.com.banco.desgraca.domain.banco.enums.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.decorators.ContaCorrente;
import br.com.banco.desgraca.domain.conta.decorators.ContaDigital;
import br.com.banco.desgraca.domain.conta.decorators.ContaPoupanca;
import br.com.banco.desgraca.domain.conta.enums.TipoContaBancaria;
import br.com.banco.desgraca.exception.CriacaoDeContaNaoPermitidaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.SaqueNaoPermitidoException;
import br.com.banco.desgraca.exception.ValorInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TesteContaBancaria {

    @Test
    @DisplayName("Testando operações com conta poupança")
    void testeContaPoupanca() {
        Assertions.assertThrows(CriacaoDeContaNaoPermitidaException.class, () -> {
            ContaPoupanca contaTeste = new ContaPoupanca(123, InstituicaoBancaria.NUBANK);
        }); //banco não aceita conta poupança.
        ContaPoupanca contaTeste = new ContaPoupanca(123, InstituicaoBancaria.BANCO_DO_BRASIL);
        contaTeste.depositar(100.00);
        Assertions.assertEquals(100.0, contaTeste.consultarSaldo());
        contaTeste.sacar(60.00);
        Assertions.assertEquals(38.80, contaTeste.consultarSaldo());
        ContaCorrente contaMesmoBanco = new ContaCorrente(1, InstituicaoBancaria.BANCO_DO_BRASIL);
        contaTeste.transferir(10.00, contaMesmoBanco);
        Assertions.assertEquals(28.75, contaTeste.consultarSaldo());
        contaTeste.depositar(1.25);
        Assertions.assertEquals(30.0, contaTeste.consultarSaldo());
        Assertions.assertEquals(10.0, contaMesmoBanco.consultarSaldo());
        ContaDigital contaOutroBanco = new ContaDigital(444,InstituicaoBancaria.NUBANK);
        contaTeste.transferir(10.0, contaOutroBanco);
        Assertions.assertEquals(10.0, contaOutroBanco.consultarSaldo());
        Assertions.assertEquals(19.90, contaTeste.consultarSaldo());

        Assertions.assertThrows(SaldoInsuficienteException.class, () -> contaTeste.sacar(50.0)); //testar saldo insuficiente.
        Assertions.assertThrows(SaqueNaoPermitidoException.class, () -> contaTeste.sacar(19.9)); //testar saque menor que o mínimo
        Assertions.assertThrows(ValorInvalidoException.class, () -> contaTeste.sacar(null));  //testar valor nulo
        Assertions.assertThrows(ValorInvalidoException.class, () ->  contaTeste.sacar(-100.00));  //testar valor negativo
        Assertions.assertThrows(SaldoInsuficienteException.class, () -> contaTeste.transferir(19.90, contaMesmoBanco)); //testar sem saldo, pois não tem para a taxa.

        contaTeste.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));
    }

    @Test
    @DisplayName("Teste operações com conta corrente.")
    void testeContaCorrente() {
        ContaCorrente contaTeste = new ContaCorrente(123, InstituicaoBancaria.CAIXA);
        contaTeste.depositar(100.00);
        Assertions.assertEquals(100.0, contaTeste.consultarSaldo());
        contaTeste.sacar(60.00);
        Assertions.assertEquals(40.00, contaTeste.consultarSaldo());
        ContaCorrente contaMesmoBanco = new ContaCorrente(1, InstituicaoBancaria.CAIXA);
        contaTeste.transferir(10.00, contaMesmoBanco);
        Assertions.assertEquals(30.00, contaTeste.consultarSaldo());
        Assertions.assertEquals(10.0, contaMesmoBanco.consultarSaldo());
        ContaDigital contaOutroBanco = new ContaDigital(444,InstituicaoBancaria.NUBANK);
        contaTeste.transferir(10.0, contaOutroBanco);
        Assertions.assertEquals(10.0, contaOutroBanco.consultarSaldo());
        Assertions.assertEquals(19.90, contaTeste.consultarSaldo());

        Assertions.assertThrows(SaldoInsuficienteException.class, () ->  contaTeste.sacar(50.0)); //testar saldo insuficiente.
        Assertions.assertThrows(SaqueNaoPermitidoException.class, () ->  contaTeste.sacar(11.00)); //testar saque não múltiplo de cinco
        Assertions.assertThrows(ValorInvalidoException.class, () -> contaTeste.sacar(null)); //testar valor nulo
        Assertions.assertThrows(ValorInvalidoException.class, () ->  contaTeste.sacar(-100.00)); //testar valor negativo
        Assertions.assertThrows(SaldoInsuficienteException.class, () ->  contaTeste.transferir(19.90, contaOutroBanco)); //testar sem saldo, pois não tem para a taxa.

        contaTeste.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));

    }

    @Test
    @DisplayName("Teste operações com conta digital.")
    void testeContaDigital() {

        Assertions.assertThrows(CriacaoDeContaNaoPermitidaException.class, () -> {
            ContaDigital contaTeste = new ContaDigital(123, InstituicaoBancaria.CAIXA);
        }); //banco não aceita conta digital.

        ContaDigital contaTeste = new ContaDigital(123, InstituicaoBancaria.ITAU);
        contaTeste.depositar(100.00);
        Assertions.assertEquals(100.0, contaTeste.consultarSaldo());
        contaTeste.sacar(60.00);
        Assertions.assertEquals(40.00, contaTeste.consultarSaldo());
        ContaCorrente contaMesmoBanco = new ContaCorrente(1, InstituicaoBancaria.CAIXA);
        contaTeste.transferir(10.00, contaMesmoBanco);
        Assertions.assertEquals(30.00, contaTeste.consultarSaldo());
        Assertions.assertEquals(10.0, contaMesmoBanco.consultarSaldo());
        ContaDigital contaOutroBanco = new ContaDigital(444,InstituicaoBancaria.NUBANK);
        contaTeste.transferir(10.0, contaOutroBanco);
        Assertions.assertEquals(10.0, contaOutroBanco.consultarSaldo());
        Assertions.assertEquals(20.00, contaTeste.consultarSaldo());

        Assertions.assertThrows(SaldoInsuficienteException.class, () ->  contaTeste.sacar(50.0)); //testar saldo insuficiente.
        Assertions.assertThrows(SaqueNaoPermitidoException.class, () ->  contaTeste.sacar(9.99)); //testar saque menor que 10 reais
        Assertions.assertThrows(ValorInvalidoException.class, () ->  contaTeste.sacar(null)); //testar valor nulo
        Assertions.assertThrows(ValorInvalidoException.class, () ->  contaTeste.sacar(-100.00)); //testar valor negativo

        contaTeste.exibirExtrato(LocalDate.of(2020,7,6), LocalDate.of(2021, 7, 6));

    }
}
