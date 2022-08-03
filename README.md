# Beskar

### A ideia por trás deste projeto foi aprender sobre o framework Spring

Com base nos tutoriais que o site Spring.io disponibiliza aprendi como funciona o fluxo de uma aplicação MVC e API-Restful.

**Ferramentas e Tecnologias**  
* Java 17 LTS - [Download](https://www.oracle.com/java/technologies/downloads/#java17)  
* IntelliJ Community - [Download](https://www.jetbrains.com/idea/download/#section=windows)  
* Spring Start - [Initializr](https://start.spring.io/)  

**Maven dependências**
* JPA
* HATEOAS
* Model Mapper
* Web
* H2

**Banco de dados em memória H2**  
O motivo pelo qual optei por usar esse banco de dados foi a facilidade de fazer um CRUD, já que o meu objetivo no momento era aprender sobre como criar as layers Entities, DTO, Repository, Controller e Service.

**Banco de dados Relacional PostgreSQL**  
Como alternativa poderia ter criado uma imagem do banco de dados PostgreSQL com o Docker usando o comando:
```
docker run --name spring_beskar -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres:alpine
```
A versão Alpine é ideal para desenvolvimento porque tem uma imagem bem pequena do Linux rodando o PostgreSQL.  
Como estou usando o sistema Operacional Windows, preciso ativar o WSL 2 porque o Docker exige que seja usado essa versão para radar o Docker no Windows. 
O Windows tem um componente chamado Hyper-v, habilitando ele é possível criar uma máquina virtual dentro do sistema Window sem a necessidade de virtualização via software. 
Com o Hyper-v, WSL 2 e uma imagem do Ubuntu LTS subiria o container com a porta 5432 usaria o PgAdmin para criar o banco e faria a conexão usando Spring JPA.

**Spring JPA**  
Usei Spring JPA para Criar, Ler, Atualizar e Deletar os dados sem precisar escrever uma única linha de SQL, com os principais métodos da interface JpaRepository fiz o CRUD. 
Porém é totalmente possível escrever seus próprios SQL usando @Query annotation.

**Model Mapper**  
Para proteger os dados da layer Entity do projeto usa-se DTOs ( Data Transfer Object), retornando para o Controller apenas os dados que são importantes, escondendo do client side o que é sigiloso. 
Usei o Model Mapper para pegar uma lista de objetos do tipo Entity e transformá-los em uma lista de objetos do tipo DTO. 
Esse processo visa fazer a interação com o banco de dados usando a Entity e retornar ao Controller um objeto do tipo DTO.

**HATEOAS**  
Usei Hateoas para criar links para cada dado que foi armazenado, essa funcionalidade facilita na hora de navegar pelos itens que foram trazidos do banco de dados. 
O front-end developer não precisa saber onde procurar os dados ou até escrever a uri toda vez que quiser implementar uma ação no front-end é só ele pegar a uri que ela vai levar direto aos dados requisitados.

**Referência e agradecimentos:**  
[Spring](https://spring.io/guides/tutorials/rest/)  
[Baeldung](https://www.baeldung.com/)


