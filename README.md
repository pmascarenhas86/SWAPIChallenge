<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=ENCERRADO&color=GREEN&style=for-the-badge"/>
</p>
Suite de teste para a REST API <a href="https://swapi.co/">SWAPI - The Star Wars API</a>, utilizando <a href="https://github.com/rest-assured">REST Assured</a> e <a href="https://github.com/junit-team/junit4">JUnit 4</a>.</br>
</br>
- Requisitos:</br>
  - <a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html/">Java</a></br>
  - <a href="https://maven.apache.org/">Maven</a></br>
</br>

- Para rodar os testes PELA PRIMEIRA VEZ, deve-se instalar as dependencias Maven, da seguinte forma: </br>
1 - abra o terminal na pasta raiz do projeto </br>
2 - execute o seguinte comando: </br>
```
mvn clean install
```

Nas demais execucoes, basta realizar o processo:
1 - abra o terminal na pasta raiz do projeto </br>
2 - execute o seguinte comando: </br>

```
mvn test
```

Relatorios:
Para criar os reports, apos os comandos supra, execute
```
mvn surefire-report:report
```
Os relatorios serao disponibilizados em: target/surefire-reports/
