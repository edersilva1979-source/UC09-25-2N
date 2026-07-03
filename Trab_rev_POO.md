# 🎮 Trabalho Prático de POO com TypeScript
# Locadora de Games: Sistema de Locação de Jogos

## 🧑‍🏫 Apresentação

Neste trabalho, vamos aplicar os principais conceitos de **Programação Orientada a Objetos com TypeScript** em um projeto simples, divertido e muito próximo de um sistema real.

Imagine que você foi contratado para desenvolver um pequeno sistema para uma **locadora de jogos**. Sim, uma locadora de games, aquele lugar onde o cliente escolhe um jogo, leva para casa, promete devolver no prazo e depois some como se tivesse entrado em uma fase secreta. 🎮😂

Sua missão será criar um sistema capaz de registrar jogos, clientes e locações.

---

# 🎯 Objetivo do Trabalho

Criar um sistema em **TypeScript** utilizando POO para controlar a locação de jogos.

O sistema deverá permitir:

* Criar jogos.
* Criar clientes.
* Registrar locações.
* Exibir qual jogo foi locado.
* Exibir para qual cliente o jogo foi locado.
* Informar a data da locação.
* Informar a previsão de devolução.
* Verificar se a locação está atrasada.
* Exibir um resumo completo da locação.

---

# 🧠 Conceitos Trabalhados

Neste trabalho você irá praticar:

* Classes.
* Objetos.
* Construtores.
* Atributos.
* Métodos.
* Relacionamento entre objetos.
* Encapsulamento básico.
* Regras de negócio.
* Datas em TypeScript.
* Exibição de informações no console.

---

# 🧩 Classes do Projeto

O sistema deverá possuir **3 classes principais**.

## 🎮 Classe JogoGame

Representa um jogo disponível para locação.

### Atributos sugeridos

```typescript
nome: string
plataforma: string
genero: string
valorDiaria: number
disponivel: boolean
```

### Explicação dos atributos

| Atributo | Descrição |
| --- | --- |
| nome | Nome do jogo |
| plataforma | Plataforma do jogo, como PS5, Xbox, PC ou Nintendo Switch |
| genero | Gênero do jogo, como aventura, corrida, luta ou RPG |
| valorDiaria | Valor cobrado por dia de locação |
| disponivel | Indica se o jogo está disponível ou locado |

---

## 👤 Classe Cliente

Representa o cliente que irá locar o jogo.

### Atributos sugeridos

```typescript
nome: string
idade: number
telefone: string
email: string
```

### Explicação dos atributos

| Atributo | Descrição |
| --- | --- |
| nome | Nome do cliente |
| idade | Idade do cliente |
| telefone | Telefone para contato |
| email | E-mail do cliente |

---

## 📝 Classe Locacao

Representa a locação de um jogo para um cliente.

### Atributos sugeridos

```typescript
jogo: JogoGame
cliente: Cliente
dataLocacao: string
dataDevolucao: string
```

### Explicação dos atributos

| Atributo | Descrição |
| --- | --- |
| jogo | Objeto da classe JogoGame |
| cliente | Objeto da classe Cliente |
| dataLocacao | Data em que o jogo foi locado |
| dataDevolucao | Data prevista para devolução |

---

# 🔗 Relacionamento entre Objetos

Observe que a classe `Locacao` recebe um `JogoGame` e um `Cliente`.

Isso significa que a locação depende desses dois objetos para existir.

Visualmente, podemos imaginar assim:

```text
                  Locacao
                     │
        ┌────────────┴────────────┐
        │                         │
     JogoGame                  Cliente
```

Ou seja, uma locação informa:

* Qual jogo foi alugado.
* Quem alugou o jogo.
* Quando alugou.
* Quando deve devolver.
* Se está atrasado ou não.

---

# 📌 Regras do Sistema

O sistema deverá seguir as seguintes regras:

1. Um jogo começa como disponível.
2. Quando uma locação é criada, o jogo deve ficar indisponível.
3. O sistema deve exibir os dados completos da locação.
4. O sistema deve verificar se a devolução está atrasada.
5. Se a data atual for maior que a data de devolução, a locação está atrasada.
6. Se a data atual for menor ou igual à data de devolução, a locação está dentro do prazo.

---

# 💻 Código Base Completo em TypeScript

Crie um arquivo chamado:

```text
index.ts
```

Depois cole o código abaixo:

```typescript
class JogoGame {
  constructor(
    public nome: string,
    public plataforma: string,
    public genero: string,
    public valorDiaria: number,
    public disponivel: boolean = true
  ) {}

  locar(): void {
    if (!this.disponivel) {
      console.log(`❌ O jogo ${this.nome} já está locado.`);
      return;
    }

    this.disponivel = false;
    console.log(`🎮 O jogo ${this.nome} foi locado com sucesso!`);
  }

  devolver(): void {
    this.disponivel = true;
    console.log(`✅ O jogo ${this.nome} foi devolvido e está disponível novamente.`);
  }

  exibirDados(): void {
    console.log("====================================");
    console.log(`🎮 Jogo: ${this.nome}`);
    console.log(`🕹️ Plataforma: ${this.plataforma}`);
    console.log(`📂 Gênero: ${this.genero}`);
    console.log(`💰 Valor da diária: R$ ${this.valorDiaria.toFixed(2)}`);
    console.log(`📌 Disponível: ${this.disponivel ? "Sim" : "Não"}`);
    console.log("====================================");
  }
}

class Cliente {
  constructor(
    public nome: string,
    public idade: number,
    public telefone: string,
    public email: string
  ) {}

  exibirDados(): void {
    console.log("====================================");
    console.log(`👤 Cliente: ${this.nome}`);
    console.log(`🎂 Idade: ${this.idade} anos`);
    console.log(`📞 Telefone: ${this.telefone}`);
    console.log(`📧 E-mail: ${this.email}`);
    console.log("====================================");
  }
}

class Locacao {
  constructor(
    public jogo: JogoGame,
    public cliente: Cliente,
    public dataLocacao: string,
    public dataDevolucao: string
  ) {
    this.jogo.locar();
  }

  estaAtrasada(dataAtual: string): boolean {
    const atual = new Date(dataAtual);
    const devolucao = new Date(this.dataDevolucao);

    return atual > devolucao;
  }

  calcularDiasLocados(): number {
    const inicio = new Date(this.dataLocacao);
    const fim = new Date(this.dataDevolucao);

    const diferencaTempo = fim.getTime() - inicio.getTime();
    const dias = diferencaTempo / (1000 * 60 * 60 * 24);

    return dias;
  }

  calcularValorPrevisto(): number {
    return this.calcularDiasLocados() * this.jogo.valorDiaria;
  }

  exibirResumo(dataAtual: string): void {
    console.log("\n====================================");
    console.log("🎮 RESUMO DA LOCAÇÃO");
    console.log("====================================");
    console.log(`Jogo locado: ${this.jogo.nome}`);
    console.log(`Plataforma: ${this.jogo.plataforma}`);
    console.log(`Gênero: ${this.jogo.genero}`);
    console.log("------------------------------------");
    console.log(`Cliente: ${this.cliente.nome}`);
    console.log(`Telefone: ${this.cliente.telefone}`);
    console.log(`E-mail: ${this.cliente.email}`);
    console.log("------------------------------------");
    console.log(`Data da locação: ${this.dataLocacao}`);
    console.log(`Previsão de devolução: ${this.dataDevolucao}`);
    console.log(`Valor previsto: R$ ${this.calcularValorPrevisto().toFixed(2)}`);
    console.log("------------------------------------");

    if (this.estaAtrasada(dataAtual)) {
      console.log("🚨 Situação: Locação atrasada!");
      console.log("O cliente entrou no modo chefão final da enrolação. 😂");
    } else {
      console.log("✅ Situação: Locação dentro do prazo.");
      console.log("Cliente responsável desbloqueou conquista rara. 🏆");
    }

    console.log("====================================\n");
  }
}

const jogo1 = new JogoGame(
  "The Legend of Zelda: Tears of the Kingdom",
  "Nintendo Switch",
  "Aventura",
  12.5
);

const jogo2 = new JogoGame(
  "Marvel's Spider-Man 2",
  "PlayStation 5",
  "Ação",
  15
);

const cliente1 = new Cliente(
  "Lucas Pereira",
  17,
  "(51) 99999-0000",
  "lucas@email.com"
);

const cliente2 = new Cliente(
  "Mariana Souza",
  18,
  "(51) 98888-1111",
  "mariana@email.com"
);

const locacao1 = new Locacao(
  jogo1,
  cliente1,
  "2026-07-01",
  "2026-07-05"
);

const locacao2 = new Locacao(
  jogo2,
  cliente2,
  "2026-07-01",
  "2026-07-10"
);

locacao1.exibirResumo("2026-07-08");
locacao2.exibirResumo("2026-07-08");

jogo1.exibirDados();
jogo2.exibirDados();
```

---

# ▶️ Como Executar

No terminal do VS Code, execute:

```bash
npx ts-node index.ts
```

Caso o projeto ainda não esteja configurado, use:

```bash
npm init -y
npm install -D typescript ts-node @types/node
npx tsc --init
```

Depois execute novamente:

```bash
npx ts-node index.ts
```

---

# 📺 Exemplo de Saída Esperada

```text
🎮 O jogo The Legend of Zelda: Tears of the Kingdom foi locado com sucesso!
🎮 O jogo Marvel's Spider-Man 2 foi locado com sucesso!

====================================
🎮 RESUMO DA LOCAÇÃO
====================================
Jogo locado: The Legend of Zelda: Tears of the Kingdom
Plataforma: Nintendo Switch
Gênero: Aventura
Cliente: Lucas Pereira
Data da locação: 2026-07-01
Previsão de devolução: 2026-07-05
Valor previsto: R$ 50.00
🚨 Situação: Locação atrasada!
```

---

# 🧪 Tarefas Obrigatórias

O aluno deverá entregar:

1. Código completo em TypeScript.
2. As três classes criadas.
3. Pelo menos dois jogos cadastrados.
4. Pelo menos dois clientes cadastrados.
5. Pelo menos duas locações cadastradas.
6. Exibição completa das locações.
7. Verificação de atraso.
8. Comentários no código explicando os principais métodos.

---

# ⭐ Desafios Extras

## 🥉 Desafio 1

Crie um método chamado:

```typescript
calcularMulta(dataAtual: string): number
```

Regra sugerida:

```text
R$ 5,00 por dia de atraso
```

---

## 🥈 Desafio 2

Crie uma classe chamada:

```typescript
Locadora
```

Ela deverá possuir:

```typescript
nome: string
jogos: JogoGame[]
clientes: Cliente[]
locacoes: Locacao[]
```

---

## 🥇 Desafio 3

Na classe `Locadora`, crie métodos para:

```typescript
adicionarJogo()
adicionarCliente()
registrarLocacao()
listarJogos()
listarClientes()
listarLocacoes()
```

---

## 🏆 Desafio 4

Crie um menu no terminal usando `readline-sync`.

O menu deverá permitir:

```text
1. Cadastrar jogo
2. Cadastrar cliente
3. Registrar locação
4. Listar locações
5. Verificar atrasos
6. Sair
```

---

# 💡 Dica do Professor

Neste trabalho, a classe `Locacao` é o coração do sistema.

Ela une duas informações importantes:

* O jogo locado.
* O cliente que locou.

Isso é um exemplo claro de relacionamento entre objetos.

A locação não precisa copiar todas as informações do cliente e do jogo. Ela apenas guarda os objetos.

Essa é uma forma muito mais organizada de programar.

---

# 😂 Momento Verdade

Se o cliente devolver o jogo no prazo:

```text
Cliente responsável. Merece desconto e respeito. 🏆
```

Se atrasar:

```text
Alerta máximo. O jogo foi para outra dimensão. 🚨🎮
```

---

# 🏁 Conclusão

Neste trabalho você praticou Programação Orientada a Objetos criando um sistema de locação de jogos.

Você trabalhou com classes, objetos, construtores, métodos, relacionamento entre classes, datas e regras de negócio.

Esse projeto é pequeno, mas já possui a lógica de muitos sistemas reais.

Locadoras, bibliotecas, lojas, escolas e hospitais utilizam ideias muito parecidas.

A diferença é que, aqui, o cliente talvez esteja apenas atrasado com um jogo. Em sistemas maiores, o atraso pode ser de boleto, consulta, entrega ou matrícula.

A lógica é a mesma.

Boa programação e cuidado para não atrasar a devolução do game. 🎮🚀
