# ATENÇÃO AVALIADORES!!! LEIAM AQUI !!

Tive alguns dilemas para resolver neste projeto, vou descrever as formas com que procedi:

1. Perdi algum tempo tentando escolher a melhor maneira de não repetir código porque as as classes Filmes e Series, assim como Diretor e Ator, eram muito semelhantes.
Fiquei num impasse se devia usar herança ou não, por isso perguntei aos intrutores como proceder, sabendo que neste momento isso não era importante, resolvi repetir os códigos e fazer uma implementação individual para cada coisa. Isso me incomodou de certa forma, pois aparentemente não deve ser a maneira mais elegante de desenvolver este desafio. Mas eu precisava ir em frente, quem sabe refatore mais para frente... Então sim, tem bastante código repetido. :(

2. Ao criar Atores era preciso passar os IDs dos filmes que eles atuaram, e para criar Filmes era preciso passar os IDs do elenco. Porém ao criar um sem existir o outro, fica um tanto incoerente (passar um ID de algo que ainda não existe). Este problema foi o que mais me tomou tempo para resolver, e consegui implementando uma classe que representaria um banco de dados (BancoDeDadosResetFlix). Nela há referências de ids de uma classe para outra (ex: Filme->Ator e Ator->Filme), logo, eu não permito no aplicativo criar tanto um quanto o outro, se passar algum ID que não exista (retornará erro 400). E caso sejam passados IDs válidos, ele não só cria a entidade desejada, como atualiza as demais envolvidas. Por exemplo, se tenho já alguns atores cadastrados, sem nenhuma indicaçào de filme que participaram, ao criar um novo Filme que passe o ID destes atores, o filme será criado, e cada ator será atualizado com o ID deste novo filme. Ou seja, fiz uma referência cruzada entre ambos através de Hashmaps. 

3. Realizei os testes através do Postman, que ferramenta maravilhosa! :)

Obrigado!

____________________________________________________________________________________________________________

# ENUNCIADO ORIGINAL RESETFLIX:

O seu objetivo neste projeto é implementar o sistema do RESETFLIX, que definitivamente não é relacionado ao Netflix de maneira alguma.


## Swagger
 A definição do Swagger desejado pode ser encontrada [aqui.](https://pastebin.com/raw/2Aga2tpZ)

 Você deve copiar o conteúdo e colar no [editor.swagger.io.](https://editor.swagger.io/)


## Postman
 A coleção do Postman do RESETFLIX pode ser obtida [aqui.](https://www.getpostman.com/collections/bf5365eed7a1b9a3c547)
 
 Ao importar ela no Postman, você terá acesso a todas as requests, bem como exemplos de todos os retornos
 esperados.
 
 ## Swagger Local
 
 Para acessar o Swagger local, você deve rodar a aplicação e acessar a URL 
 http://localhost:8080/swagger-ui/
 
 Através desta URL, você poderá executar testes no seu código pelo Swagger UI.
 
 ### Implementações
 
* Obs: Se atentar ao padrão de pacotes (Controllers, Services, Repositories) 
e divisão de classes (Requests, Response, Entity, Mapper, Repository)

### Atores
- Os atores devem ter um Id, um Nome e uma lista de filmes dos quais participaram.
- Deve ser possível:
    - Listar atores (apenas Id e Nome)
    - Criar um novo ator (Nome e Ids de Filmes dos quais participou)
    - Obter detalhes de um ator (retorna seu Id, Nome, e Filmes dos quais participou)

### Diretores
- Exatamente as mesmas implementações dos Atores.

### Filmes
- Os filmes devem ter um Id, um Nome, um Genero, um Id de Diretor, e uma lista de Ids de atores.
- Deve ser possível:
    - Listar filmes (filtrando por Gênero, que é opcional). Deve trazer Id, Gênero e Nome.
    - Criar um novo Filme (Nome, Genero, Id de diretor e Ids de atores)
    - Obter detalhes de um filme (retorna seu Id, Nome, Genero, dados básicos do Diretor e dos Atores)
    
### Séries
- As mesmas implementações dos Filmes, mas ao invés de um Diretor, elas terão quantidade de Temporadas e Episódios.

# DESAFIO!

Implementar os endpoints 
> /filmes/{id}/assistir 

>/series/{id}/{temporada}/{episodio}/assistir

Devem registrar que o usuário assistiu ao conteúdo.
Pode-se considerar que essa aplicação está sendo utilizada sempre
pelo mesmo usuário, que poderá ser tratado como uma Entidade.

# DESAFIO 2 - A MISSÃO!
Implementar os endpoints
> /filmes/recomendacoes

> /series/recomendacoes

Devem retornar alguma série ou filme do Gênero 
mais assistido pelo usuário (obtido através do conteudo assistido).

O conteúdo retornado não deve ter sido assistido pelo usuário.

Caso não tenha o que recomendar, deve jogar uma _UsuarioDesocupadoException_.
