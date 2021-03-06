# Banco da Desgraça

## Mensagem aos avaliadores:

            Caros, algumas observações:

            OBS 1: Decidi criar uma classe Banco responsável por criar contas bancárias (como se fosse uma Factory).
            Sei que o enunciado não exigia esta funcionalidade, por isso neste sistema seu uso é opcional.
            Caso seja usada, ela verifica o número de conta e impede a abertura de contas com o mesmo número.
            Como sei que irão rodas linhas de teste que já foram desenvolvidas, deixei as classes ContaCorrente,
            ContaDigital e ContaPoupanca com seus construtores públicos. Porém na minha proposta o ideal seria
            que fossem protegidas, e apenas a classe Banco poderia instanciá-las, conforme ocorre no mundo real: bancos
            abrem contas solicitadas por clientes.
            Mas é apenas uma proposta, o código deverá rodar sem a utilização da classe Banco, da mesma forma.

            OBS 2: Optei pelo uso de Decorators para diferenciar os tipos de conta. Cada um implementa ContaBancaria e
            estende ContaGenerica, adicionando apenas as regras do enunciado (taxas, valor mín para saque, e etc).
            Desta forma evito ter que colocar as regras em cada classe de tipo de conta.

            OBS 3: Criei testes unitários, algo novo para mim, que tentei usar neste projeto. Para isso utilizei:
            o JUnit ("org.junit.jupiter:junit-jupiter:5.6.2), tais testes se encontram no diretório "test". Ao rodar
            os testes descobri vários erros (maioria por arredondamento), já corrigidos.

            OBS 4: Utilizei BigDecimal para corrigir problemas de arrendondamento com Double, principalmente na parte de
            cobrar as taxas pelas transações. 

### Enunciado:

Criar um sistema para gestão de contas bancárias, possibilitando funções de entrada, saída, transferência e extrato.

_Obs.: você deve criar um projeto novo chamado `banco-da-desgraca` e copiar a mesma estrutura de classes e packages fornecida neste projeto de exemplo._


### Tipos de contas bancárias

Devem ser criados três tipos de contas bancárias: `ContaPoupanca`, `ContaCorrente` e `ContaDigital`. 

_Composição das contas bancárias:_

* Toda conta bancária possui um número de conta corrente;
* Toda conta bancária possui uma instituição bancária;
* As instituições bancárias contempladas até o momento são: Banco do Brasil, Bradesco, Caixa, Itaú e Nubank;
* Toda conta bancária precisa sobrescrever o método `toString` para que fique neste formato de exemplo _(perceba que o nome do banco está "apresentável")_: `Conta Digital Nubank 123`, `Conta Poupança Caixa Econômica Federal 873`, etc.

_Regras específicas dos tipos de contas bancárias:_

* `ContaDigital`: não possui nenhum tipo de taxa, todas as operações são gratuitas. Os saques só são permitidos se o valor solicitado for de pelo menos R$ 10,00;
* `ContaCorrente`: é livre de taxas, exceto para transferências para outras instituições bancárias _(neste caso, a taxa é de 1% do valor a ser transferido)_. O saque só pode ser feito para valores divisíveis por 5 _(ou seja, notas de R$ 5,00, R$ 10,00, R$ 20,00, R$ 50,00, R$ 100,00 e R$ 200,00)_;
* `ContaPoupanca`: possui taxa de 2% para saques, sendo que o valor mínimo para solicitação de saque é de R$ 50,00. Possui taxa de 0,5% para transferências para mesma instituição bancária e 1% para outras instituições bancárias;

_Regras sobre instituições bancárias:_
* Somente Itaú e Nubank permitem contas digitais;
* Somente Nubank não permite conta poupança.

### Regras gerais

* **Não é permitido alterar a interface `ContaBancaria`**;
* Você precisará completar a classe `Transacao` com o tipo da transação, a data da transação e o valor da transação;
* Utilize o método `main` de `BancoDaDesgraca` para criar casos de testes. Crie várias contas bancárias e efetue diversos tipos de transação;
* As classes que representam contas bancárias devem ser criadas no package `br.com.banco.desgraca.domain.conta`;
* Sempre que precisar imprimir um valor monetário, use `DecimalFormat.getCurrencyInstance().format()`;
* Todos as operações da conta bancária devem imprimir uma mensagem indicando a operação que foi feita. Deve ser o mais legível possível. Ex.:
  * `Sacando valor R$ 50,00 da Conta Poupança Bradesco 123`
  * `Depositando valor R$ 25,00 na Conta Corrente Banco do Brasil 555`
  * `Transferindo valor R$ 100,00 da Conta Digital Nubank 123 para conta corrente Itaú 789`
* Toda e qualquer situação que infrinja uma restrição deve lançar uma exceção específica e customizada para indicar o problema. Um exemplo pode ser visto no package `exception`;
* Se achar necessário, crie uma classe abstrata para evitar trabalho repetitivo;
* Você precisará criar algumas classes e completar outras que já existem no projeto inicial;
* Lembre-se de utilizar o Google para pesquisar algumas coisas :)


### Regra da data

Para que o exemplo fique completo, precisamos também trabalhar com datas, que estarão associadas às transações.

Sempre que você precisar de uma data para criar uma transação, utilize a classe utilitária `Data` _(localizada na raiz do projeto)_ que já possui um método `getDataTransacao()`.
Toda vez que você chamar este método, será acrescido 5 dias à uma data estipulada como início _(01/07/2020)_.
