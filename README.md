# API de gerenciamento de equipamentos dentro de uma companhia

Essa API foi construída com o intuito de resolver alguns problemas pessoais relacionados ao gerenciamento de equipamentos eletrônicos.

Durate a construção dessa API, foram abordados os seguintes conceitos:
* API Rest/Restiful
* Nível de maturidade de Richardson
* Frameworks Java
* Springboot
* MapStruck
* Lombok
* Java TEST

Para rodar essa aplicação, após o feito o clone do repositório em sua máquina local, basta executar o comando:
```
mvn spring-boot:run
```

E a API estará funcionando com um localserver do _TOMCAT_. Para acessar a mesma, basta ir ao endereço:
```
localhost:8080/equipment
```

O passo-a-passo da criação dessa API se deu da seguinte forma:
1. A criação das entidades de negócio, que se comunicam e serve de modelo para o repositório (DB);
2. A criação das DTOs (objetos que fazem o trabalho de transferência entre os endpoints e as entidades de negócio);
3. A criação da classe mapper, que com o auxilio do _MapStruct_, faz o mapeamento e conversão entre os DTOs e Models;
4. A criação da interface repository, que auxilia o gerenciamento do banco de dados propriamente dito;
5. Criação da classe service, a estrutura as regras de negócio da aplicação e tem relação direta com a classe controler e repository;
6. Criação da classe controller para estabelecer o padrão REST e com isso realizar a comunicação com o browser/Postman;
7. Ao final foi realizado uma série de testes unitários no controller e service utilizando o Mockito, Hamcrast e JUnit;

O processo de desenvolvimento ainda não está concluído, pois, além de projeto pessoal, a API serve para uso pessoal de negócio e, futuramente pretendo adicionar novas funcionalidades e uma interface gráfica que consome esta API.

> Desenvolvido por: Raí Rafael