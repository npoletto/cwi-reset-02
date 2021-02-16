package main;

import main.entidades.Beneficiario;
import main.entidades.Imovel;
import main.entidades.UnidadeFederativa;


import java.util.HashMap;
import java.util.Map;

public class PropostaFinanciamento {

    //Optei por usar Hashmap com a UnidadeFederativa como chave, facilitando para inclusão de novas exceções:
    private Map<UnidadeFederativa, Double> excecoes = new HashMap<>();

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    private Imovel imovel;
    private Beneficiario beneficiario;
    private Integer prazoPagamento;
    private boolean isPropostaAprovada;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, Integer prazoPagamento) {
        this.imovel = imovel;
        this.beneficiario = beneficiario;
        this.prazoPagamento = prazoPagamento;
        excecoes.put(UnidadeFederativa.RIO_DE_JANEIRO, 0.6);
        excecoes.put(UnidadeFederativa.SAO_PAULO, 0.65);
    }

    public void validarProposta() {
        double multiplicadorValor;
        multiplicadorValor = excecoes.getOrDefault(imovel.getEndereco().getUnidadeFederativa(), 0.5); //Procura por exceções no HashMap, senão usa default de 0.5
        isPropostaAprovada = beneficiario.getSalario() * prazoPagamento  >= imovel.getValor() * multiplicadorValor;
        imprimirCabecalho();
        if (isPropostaAprovada) {
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaReprovada();
        }
    }

    private void imprimirCabecalho() {
        System.out.println( "Caro " + beneficiario.getNome() + ", " +
                            "\nsua proposta em " + prazoPagamento + "X, "+
                            "\npara o endereço: " + imovel.getEndereco());
    }

    private void imprimirPropostaAprovada() {
        System.out.println( "Foi aprovada! Parabéns, você não será mais um morador de rua!"+
                            "\nMas fique em dia com as parcelas, senão...");
    }

    private void imprimirPropostaReprovada() {
        System.out.println( "Foi reprovada! O imóvel será destinado a alguém que possa pagar, e não é você!");
    }
}
