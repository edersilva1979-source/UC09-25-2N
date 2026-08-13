# A História do MVC

## Como nasceu uma das arquiteturas mais importantes do desenvolvimento de software

> Uma breve viagem pela história do Model View Controller, desde sua criação até os dias atuais.

---

# Introdução

Hoje, quando falamos em desenvolvimento de software, é muito comum ouvirmos a sigla **MVC**.

Ela está presente em diversas linguagens e frameworks, como Java, C#, PHP, Python, Ruby, JavaScript e muitas outras.

Mas você já parou para pensar:

* Quem inventou o MVC?
* Quando ele surgiu?
* Por que ele foi criado?
* Será que ele sempre teve esse nome?

Nesta aula, eu vou contar essa história de forma simples e curiosa.

---

# O nascimento do MVC

O MVC nasceu no final da década de 1970.

Mais precisamente em **1979**, no famoso laboratório de pesquisas da Xerox, chamado **Xerox PARC (Palo Alto Research Center)**, localizado na Califórnia, Estados Unidos.

O criador do MVC foi o cientista da computação norueguês **Trygve Reenskaug**.

Na época, ele estava trabalhando como pesquisador visitante no Xerox PARC, um dos laboratórios mais inovadores da história da computação.

---

# O que era o Xerox PARC?

Se hoje nós utilizamos mouse, janelas, ícones e interfaces gráficas, boa parte dessas ideias passou pelo Xerox PARC.

Foi lá que nasceram ou evoluíram tecnologias como:

* Interface gráfica (GUI)
* Mouse moderno
* Ethernet
* Impressoras a laser
* Smalltalk
* Programação orientada a objetos

Era praticamente um laboratório onde várias tecnologias do futuro estavam sendo criadas ao mesmo tempo.

---

# O problema que precisava ser resolvido

Naquela época, os programas estavam ficando cada vez maiores.

As interfaces gráficas começavam a substituir as antigas telas somente com texto.

Isso trouxe um novo desafio.

Imagine um sistema de cadastro.

O mesmo aluno poderia aparecer:

* Em uma tabela
* Em um formulário
* Em um relatório
* Em um gráfico

Sempre que um dado fosse alterado, todas essas telas deveriam ser atualizadas.

Era necessário criar uma forma organizada de separar:

* os dados;
* a forma como esses dados eram exibidos;
* e a lógica que controlava tudo isso.

Foi justamente desse problema que nasceu o MVC.

---

# O primeiro nome do MVC

Aqui existe uma curiosidade muito interessante.

O padrão **não nasceu com o nome MVC**.

O primeiro nome imaginado por Reenskaug foi:

```text
Thing
Model
View
Editor
```

Depois ele passou para:

```text
Model
View
Editor
```

Somente após várias discussões com outros pesquisadores do grupo Smalltalk, especialmente com **Adele Goldberg**, o nome foi simplificado para:

```text
Model
View
Controller
```

Ou seja, o famoso MVC quase teve outro nome.

---

# A primeira implementação

A primeira implementação prática aconteceu utilizando a linguagem **Smalltalk**, uma das linguagens que ajudou a popularizar a programação orientada a objetos.

O MVC fazia parte do ambiente Smalltalk e foi apresentado ao público com o **Smalltalk 80**, tornando o padrão conhecido por outros desenvolvedores.

---

# O objetivo original

Curiosamente, o objetivo do MVC nunca foi organizar projetos web.

Na verdade, ele foi criado para aplicações com interfaces gráficas.

A ideia era permitir que:

* um mesmo conjunto de dados;
* pudesse ser exibido de várias formas diferentes;
* sem duplicar informações.

Hoje isso parece comum.

Na época, era uma ideia bastante inovadora.

---

# Como o MVC ficou famoso?

Durante muitos anos, o MVC foi utilizado principalmente em aplicações desktop.

A explosão de popularidade aconteceu muitos anos depois.

Na década de 1990 e principalmente nos anos 2000, diversos frameworks começaram a utilizar MVC.

Alguns exemplos:

* Ruby on Rails
* ASP.NET MVC
* Spring MVC
* Laravel
* CodeIgniter
* CakePHP

Esses frameworks ajudaram o padrão a se tornar praticamente um padrão de mercado.

---

# Curiosidade 1

### O MVC já tem mais de 45 anos.

Mesmo sendo criado em 1979, ele continua sendo utilizado até hoje.

Poucas ideias em tecnologia permanecem relevantes por tanto tempo.

---

# Curiosidade 2

O MVC nasceu antes mesmo da internet comercial.

Quando ele foi criado:

* não existia Google;
* não existia Java;
* não existia Windows;
* não existia smartphone;
* nem existia a Web como conhecemos hoje.

Mesmo assim, a arquitetura continua atual.

---

# Curiosidade 3

Quando o MVC surgiu, a linguagem Java ainda demoraria cerca de **16 anos** para ser lançada.

O Java apareceu apenas em **1995**.

Ou seja, quando programamos Java utilizando MVC, estamos aplicando uma ideia muito mais antiga do que a própria linguagem.

---

# Curiosidade 4

O MVC foi criado pensando em programas desktop.

Hoje ele é utilizado em:

* aplicações web;
* sistemas desktop;
* aplicativos móveis;
* APIs;
* sistemas embarcados;
* aplicações corporativas.

O conceito conseguiu atravessar gerações de tecnologias.

---

# Curiosidade 5

O próprio criador comentou anos depois que dar nomes às partes do MVC foi uma das tarefas mais difíceis do projeto.

Segundo ele, encontrar nomes simples que representassem corretamente cada responsabilidade levou bastante tempo.

---

# Uma curiosidade divertida

Imagine a seguinte situação.

Em 1979, alguém diz:

"Vamos criar uma arquitetura para organizar melhor nossos programas."

Provavelmente ninguém imaginava que, mais de quatro décadas depois, milhões de estudantes ainda estariam aprendendo exatamente essa arquitetura.

Poucas ideias conseguem envelhecer tão bem.

---

# Outra curiosidade interessante

Muitas pessoas acreditam que MVC foi criado para Java.

Na verdade:

```text
Não.
```

Também não foi criado para PHP.

Nem para C#.

Nem para JavaScript.

Essas linguagens simplesmente adotaram um padrão que já existia.

---

# Por que o MVC continua sendo utilizado?

Porque ele resolve um problema que nunca deixou de existir.

Todo sistema possui:

* dados;
* interface;
* regras.

Separar essas responsabilidades continua fazendo sentido.

É justamente por isso que o MVC permanece tão atual.

---

# O legado do MVC

O MVC inspirou diversas outras arquiteturas.

Entre elas:

* MVP
* MVVM
* HMVC
* PAC
* MVPVM

Todas nasceram tentando adaptar ou evoluir alguns conceitos do MVC.

---

# Linha do tempo

```text
1979

Trygve Reenskaug cria o MVC
no Xerox PARC

↓

1980

MVC aparece no Smalltalk-80

↓

Década de 1990

Começa a ser utilizado em
mais aplicações desktop

↓

Anos 2000

Explosão dos frameworks Web

↓

Hoje

Um dos padrões arquiteturais
mais utilizados do mundo
```

---

# Resumo

Nesta aula, eu aprendi que:

* o MVC foi criado em **1979**;
* seu criador foi **Trygve Reenskaug**;
* ele nasceu no **Xerox PARC**;
* inicialmente não se chamava MVC;
* foi desenvolvido para aplicações gráficas;
* continua sendo utilizado até hoje;
* inspirou diversas arquiteturas modernas.

---

# Frase para lembrar

> "Tecnologias mudam rapidamente. Boas ideias permanecem."

Essa frase representa muito bem a história do MVC.

Mais de quarenta anos depois de sua criação, ele continua ajudando desenvolvedores do mundo inteiro a escrever sistemas mais organizados, fáceis de manter e preparados para crescer.

