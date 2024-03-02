<h1 align="center"> Exercício 2 - Aplicando TDD </h1>

## 1. Sobre

Este repositório foi criado com intuito de resolver o exercício número 2 da disciplina de Verificação e Validação de Software. 

### Alunos:

* [Anderson Victor da Silva Siqueira Melo](https://github.com/Anderson-Melo)
* [Fernando Gabriel Marques da Silva](https://github.com/GALSANTA)

## 2. Requisitos

* Uma máquina virtual ubuntu 20.04.
* Paciência

## 3. Dependências

```bash
sudo apt install default-jre
sudo apt-get install maven
sudo apt install make
```

## 4. Como executar

Com as dependências instaladas previamente erode os seguintes comandos e siga as instruções para para cada sistema.

```bash
git clone https://github.com/GALSANTA/tdd
cd ./tdd
```

### 4.1 Gerador de Nota Fiscal

#### Buildando o projeto:

```bash
cd ./fiscal
make build
```

#### Como executar o sistema:

```bash
make fiscal
```

#### Como executar os testes:

```bash
make test
```

## Referências

* https://ubuntu.com/tutorials/install-jre#2-installing-openjdk-jre
* https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html