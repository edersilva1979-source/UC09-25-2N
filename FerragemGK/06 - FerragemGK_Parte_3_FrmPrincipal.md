# Projeto FerragemGK

# Parte 3: Criando a FrmPrincipal com JMenuBar, JDesktopPane, JInternalFrame e Controle de Permissões

Nesta etapa, nós vamos criar juntos a tela principal do sistema FerragemGK.

Depois que o usuário realizar o login corretamente, nós vamos abrir a `FrmPrincipal`.

Ela será o centro da nossa aplicação.

Dentro dela, nós vamos criar:

* `JMenuBar`
* Menus e submenus
* `JDesktopPane`
* Abertura de telas utilizando `JInternalFrame`
* Controle para impedir que a mesma tela seja aberta várias vezes
* Identificação do usuário conectado
* Identificação do nível MASTER ou USER
* Controle de permissões
* Logout
* Encerramento do sistema

Ao final desta etapa, o fluxo da aplicação ficará assim:

```text
FrmLogin
    ↓
Autenticação
    ↓
SessaoUsuario
    ↓
FrmPrincipal
    ↓
JDesktopPane
    ↓
JInternalFrame
```

---

# 1. O que nós vamos construir

A nossa tela principal será um `JFrame`.

Dentro dela, nós vamos utilizar um `JDesktopPane`.

O `JDesktopPane` funcionará como a área de trabalho do sistema.

Dentro dele, nós vamos abrir telas como:

```text
FrmCliente
FrmFornecedor
FrmProduto
FrmUsuario
FrmCompra
FrmVenda
FrmContasPagar
FrmContasReceber
```

Essas telas serão criadas utilizando:

```text
JInternalFrame
```

A estrutura ficará parecida com esta:

```text
FrmPrincipal
    │
    ├── JMenuBar
    │
    └── JDesktopPane
            │
            ├── FrmCliente
            ├── FrmFornecedor
            ├── FrmProduto
            ├── FrmUsuario
            ├── FrmCompra
            ├── FrmVenda
            ├── FrmContasPagar
            └── FrmContasReceber
```

---

# 2. Estrutura atual do projeto

Depois desta etapa, nossa organização ficará semelhante a:

```text
FerragemGK

conexao
    Conexao.java

dao
    UsuarioDAO.java

model
    Usuario.java

util
    SessaoUsuario.java

view
    FrmLogin.java
    FrmPrincipal.java
```

Mais adiante nós acrescentaremos os demais `JInternalFrame`.

---

# 3. Criando a FrmPrincipal

No NetBeans, nós vamos acessar o pacote:

```text
view
```

Depois vamos clicar com o botão direito.

Escolheremos:

```text
New
```

Depois:

```text
JFrame Form
```

Nome:

```text
FrmPrincipal
```

A nossa classe será criada como:

```java
package view;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {

        initComponents();
    }
}
```

Depois nós vamos personalizar essa tela.

---

# 4. Configurando a janela principal

No construtor da `FrmPrincipal`, nós vamos adicionar:

```java
public FrmPrincipal() {

    initComponents();

    setLocationRelativeTo(null);

    setExtendedState(
            javax.swing.JFrame.MAXIMIZED_BOTH
    );

    carregarUsuario();

    aplicarPermissoes();
}
```

Com isso, nós vamos:

```text
Inicializar os componentes
Centralizar a janela
Abrir a janela maximizada
Mostrar o usuário conectado
Aplicar as permissões
```

---

# 5. Imports da FrmPrincipal

Nós vamos precisar adicionar alguns imports.

```java
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Usuario;
import util.SessaoUsuario;
```

Posteriormente, quando as telas existirem, elas estarão no mesmo pacote `view`.

Nesse caso, não será necessário importar classes que estejam dentro do mesmo pacote.

---

# 6. Criando o JDesktopPane

No modo Design do NetBeans, nós vamos adicionar um componente:

```text
JDesktopPane
```

Vamos alterar o nome da variável para:

```text
desktopPrincipal
```

Esse será o local onde as nossas telas internas serão abertas.

A estrutura visual será:

```text
FrmPrincipal
    ↓
desktopPrincipal
    ↓
JInternalFrame
```

---

# 7. Fazendo o JDesktopPane ocupar a tela

Nós vamos posicionar o `desktopPrincipal` para ocupar praticamente toda a área disponível da janela.

Visualmente:

```text
===============================================

              MENU PRINCIPAL

===============================================



              JDesktopPane                    




===============================================

Usuário: Administrador        Nível: MASTER

===============================================
```

Mais adiante nós também vamos adicionar uma pequena barra inferior com as informações do usuário conectado.

---

# 8. Criando a JMenuBar

Agora nós vamos adicionar:

```text
JMenuBar
```

No NetBeans, o `JMenuBar` ficará associado diretamente ao `JFrame`.

Dentro dele, nós vamos criar os seguintes menus:

```text
Sistema
Cadastros
Movimentos
Financeiro
Ajuda
```

---

# 9. Menu Sistema

Dentro de Sistema, nós vamos criar:

```text
Logout
Sair
```

Os nomes das variáveis poderão ser:

```text
mnuLogout
mnuSair
```

---

# 10. Menu Cadastros

Dentro de Cadastros, nós vamos criar:

```text
Clientes
Fornecedores
Produtos
Usuários
```

Nomes das variáveis:

```text
mnuClientes
mnuFornecedores
mnuProdutos
mnuUsuarios
```

---

# 11. Menu Movimentos

Dentro de Movimentos, nós vamos criar:

```text
Compras
Vendas
```

Variáveis:

```text
mnuCompras
mnuVendas
```

---

# 12. Menu Financeiro

Dentro de Financeiro, nós vamos criar:

```text
Contas a Pagar
Contas a Receber
```

Variáveis:

```text
mnuContasPagar
mnuContasReceber
```

---

# 13. Menu Ajuda

Dentro de Ajuda, nós podemos criar:

```text
Sobre
```

Variável:

```text
mnuSobre
```

---

# 14. Estrutura final do menu

A estrutura ficará:

```text
Sistema
    Logout
    Sair

Cadastros
    Clientes
    Fornecedores
    Produtos
    Usuários

Movimentos
    Compras
    Vendas

Financeiro
    Contas a Pagar
    Contas a Receber

Ajuda
    Sobre
```

---

# 15. Identificando o usuário conectado

Nós vamos criar dois `JLabel` na parte inferior da tela.

O primeiro terá o nome:

```text
lblUsuario
```

O segundo:

```text
lblNivel
```

Eles mostrarão algo semelhante a:

```text
Usuário: Administrador
```

e:

```text
Nível: MASTER
```

---

# 16. Método carregarUsuario

Agora nós vamos criar um método para buscar o usuário armazenado na sessão.

```java
private void carregarUsuario() {

    Usuario usuario =
            SessaoUsuario.getUsuarioLogado();

    if (usuario != null) {

        lblUsuario.setText(
                "Usuário: "
                + usuario.getNome()
        );

        lblNivel.setText(
                "Nível: "
                + usuario.getNivel()
        );

    } else {

        lblUsuario.setText(
                "Usuário: não identificado"
        );

        lblNivel.setText(
                "Nível: não identificado"
        );
    }
}
```

---

# 17. Como carregarUsuario funciona

Nós buscamos:

```java
SessaoUsuario.getUsuarioLogado();
```

Esse método retorna o objeto `Usuario` que foi salvo depois do login.

Depois nós mostramos:

```java
usuario.getNome();
```

e:

```java
usuario.getNivel();
```

Assim, a tela principal saberá quem está utilizando o sistema.

---

# 18. Controle de permissões

Agora nós vamos criar um método chamado:

```java
aplicarPermissoes();
```

Nosso projeto possui dois níveis:

```text
MASTER
USER
```

O MASTER terá acesso completo.

O USER terá restrições.

Nesta etapa, nós vamos bloquear para o USER:

```text
Cadastro de usuários
Contas a pagar
```

A proibição de excluir registros será controlada dentro de cada tela de cadastro.

---

# 19. Método aplicarPermissoes

Nós vamos criar:

```java
private void aplicarPermissoes() {

    if (SessaoUsuario.isMaster()) {

        mnuUsuarios.setEnabled(true);

        mnuContasPagar.setEnabled(true);

    } else {

        mnuUsuarios.setEnabled(false);

        mnuContasPagar.setEnabled(false);
    }
}
```

Assim, quando o usuário for MASTER, os menus estarão disponíveis.

Quando for USER, eles ficarão desabilitados.

---

# 20. Por que controlar permissões também nas telas

Nós não devemos depender apenas do menu.

Por exemplo, dentro de uma tela de cadastro, o botão Excluir também deverá verificar:

```java
SessaoUsuario.isMaster();
```

Assim nós teremos uma segunda camada de controle.

Exemplo:

```java
if (!SessaoUsuario.isMaster()) {

    JOptionPane.showMessageDialog(
            this,
            "Você não possui permissão para excluir registros."
    );

    return;
}
```

Nós vamos aplicar essa regra quando desenvolvermos os cadastros.

---

# 21. Criando um JInternalFrame de teste

Como ainda não criamos todas as telas do sistema, nós podemos criar temporariamente uma tela simples para testar o `JDesktopPane`.

No pacote:

```text
view
```

vamos criar:

```text
New
```

Depois:

```text
JInternalFrame Form
```

Nome:

```text
FrmTeste
```

No construtor:

```java
public FrmTeste() {

    initComponents();

    setTitle("Tela de Teste");

    setClosable(true);

    setIconifiable(true);

    setMaximizable(true);

    setResizable(true);
}
```

Depois nós poderemos apagar essa tela quando os cadastros reais estiverem prontos.

---

# 22. Método para abrir JInternalFrame

Nós não queremos repetir o mesmo código em todos os menus.

Por isso, vamos criar um método:

```java
private void abrirTela(
        JInternalFrame tela
) {

    for (
            JInternalFrame frame :
            desktopPrincipal.getAllFrames()
    ) {

        if (
                frame.getClass()
                .equals(
                        tela.getClass()
                )
        ) {

            try {

                frame.setSelected(true);

                if (frame.isIcon()) {

                    frame.setIcon(false);
                }

            } catch (Exception erro) {

                JOptionPane.showMessageDialog(
                        this,
                        "Não foi possível selecionar a tela."
                );
            }

            frame.toFront();

            return;
        }
    }

    desktopPrincipal.add(tela);

    tela.setVisible(true);

    centralizarInternalFrame(tela);
}
```

---

# 23. O que o método abrirTela faz

Primeiro nós percorremos todas as telas abertas:

```java
desktopPrincipal.getAllFrames();
```

Depois verificamos se já existe uma tela da mesma classe.

```java
frame.getClass().equals(
        tela.getClass()
)
```

Se existir, nós não abriremos uma nova.

Nós apenas selecionaremos a tela existente.

Se ela estiver minimizada:

```java
frame.isIcon()
```

nós vamos restaurá la.

Depois trazemos a tela para frente.

```java
frame.toFront();
```

Se a tela ainda não estiver aberta, nós fazemos:

```java
desktopPrincipal.add(tela);
```

e:

```java
tela.setVisible(true);
```

---

# 24. Por que impedir telas duplicadas

Sem esse controle, o usuário poderia clicar várias vezes em Clientes e abrir várias cópias da mesma tela.

Por exemplo:

```text
FrmCliente
FrmCliente
FrmCliente
FrmCliente
```

Isso deixaria a aplicação desorganizada.

Com nosso método, teremos apenas uma tela de cada tipo aberta por vez.

---

# 25. Centralizando o JInternalFrame

Agora nós vamos criar outro método:

```java
private void centralizarInternalFrame(
        JInternalFrame tela
) {

    int x =
            (
                desktopPrincipal.getWidth()
                - tela.getWidth()
            ) / 2;

    int y =
            (
                desktopPrincipal.getHeight()
                - tela.getHeight()
            ) / 2;

    if (x < 0) {

        x = 0;
    }

    if (y < 0) {

        y = 0;
    }

    tela.setLocation(x, y);
}
```

Esse método tentará abrir a tela interna no centro do desktop.

---

# 26. Testando com FrmTeste

Nós podemos criar temporariamente um item no menu Ajuda chamado:

```text
Abrir Tela de Teste
```

No evento:

```java
private void mnuTesteActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmTeste()
    );
}
```

Ao clicar, a tela deverá abrir dentro do:

```text
desktopPrincipal
```

Se clicarmos novamente, ela não deverá ser duplicada.

---

# 27. Preparando o menu Clientes

Quando nós criarmos `FrmCliente`, o evento será:

```java
private void mnuClientesActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmCliente()
    );
}
```

---

# 28. Preparando o menu Fornecedores

```java
private void mnuFornecedoresActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmFornecedor()
    );
}
```

---

# 29. Preparando o menu Produtos

```java
private void mnuProdutosActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmProduto()
    );
}
```

---

# 30. Preparando o menu Usuários

Como esse menu será permitido apenas para MASTER, teremos:

```java
private void mnuUsuariosActionPerformed(
        java.awt.event.ActionEvent evt
) {

    if (!SessaoUsuario.isMaster()) {

        JOptionPane.showMessageDialog(
                this,
                "Acesso permitido somente para usuário MASTER."
        );

        return;
    }

    abrirTela(
            new FrmUsuario()
    );
}
```

Mesmo com o menu desabilitado para USER, nós também validamos a permissão dentro do evento.

---

# 31. Preparando o menu Compras

```java
private void mnuComprasActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmCompra()
    );
}
```

O USER poderá realizar compras.

Se uma compra parcelada gerar contas a pagar, essa geração será automática.

Isso não significa que o USER terá permissão para administrar o contas a pagar.

---

# 32. Preparando o menu Vendas

```java
private void mnuVendasActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmVenda()
    );
}
```

---

# 33. Preparando Contas a Pagar

Somente MASTER poderá entrar diretamente nesse módulo.

```java
private void mnuContasPagarActionPerformed(
        java.awt.event.ActionEvent evt
) {

    if (!SessaoUsuario.isMaster()) {

        JOptionPane.showMessageDialog(
                this,
                "Acesso permitido somente para usuário MASTER."
        );

        return;
    }

    abrirTela(
            new FrmContasPagar()
    );
}
```

---

# 34. Preparando Contas a Receber

```java
private void mnuContasReceberActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmContasReceber()
    );
}
```

---

# 35. Importante sobre as telas futuras

Os códigos:

```java
new FrmCliente()
```

```java
new FrmFornecedor()
```

```java
new FrmProduto()
```

e os demais somente compilarão quando essas classes forem criadas.

Enquanto elas ainda não existirem, nós podemos testar a `FrmPrincipal` utilizando apenas:

```java
new FrmTeste()
```

Depois substituiremos gradualmente pelos módulos reais.

---

# 36. Criando o Logout

Agora nós vamos programar:

```text
mnuLogout
```

O logout deve:

```text
Confirmar a saída da sessão
Encerrar SessaoUsuario
Fechar FrmPrincipal
Abrir FrmLogin
```

Código:

```java
private void mnuLogoutActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja encerrar a sessão atual?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            == JOptionPane.YES_OPTION
    ) {

        SessaoUsuario.encerrar();

        FrmLogin login =
                new FrmLogin();

        login.setVisible(true);

        dispose();
    }
}
```

---

# 37. O que acontece no Logout

Quando executamos:

```java
SessaoUsuario.encerrar();
```

a variável que guarda o usuário conectado recebe:

```java
null
```

Depois nós abrimos novamente:

```java
FrmLogin
```

E fechamos:

```java
FrmPrincipal
```

---

# 38. Programando o menu Sair

Agora nós vamos programar:

```text
mnuSair
```

Código:

```java
private void mnuSairActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente encerrar o FerragemGK?",
                    "Sair",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            == JOptionPane.YES_OPTION
    ) {

        System.exit(0);
    }
}
```

---

# 39. Criando o menu Sobre

Nós podemos criar uma caixa simples.

```java
private void mnuSobreActionPerformed(
        java.awt.event.ActionEvent evt
) {

    JOptionPane.showMessageDialog(
            this,
            "FerragemGK\n"
            + "Sistema desenvolvido em Java Swing\n"
            + "Banco de dados PostgreSQL"
    );
}
```

---

# 40. Alterando a FrmLogin

Na etapa anterior, depois de autenticar corretamente nós mostramos apenas uma mensagem.

Agora nós vamos alterar isso.

Localize na `FrmLogin`:

```java
if (usuario != null) {

    SessaoUsuario.iniciar(usuario);

    JOptionPane.showMessageDialog(
            this,
            "Bem vindo, "
            + usuario.getNome()
            + "!"
    );
}
```

Nós vamos substituir por:

```java
if (usuario != null) {

    SessaoUsuario.iniciar(usuario);

    FrmPrincipal principal =
            new FrmPrincipal();

    principal.setVisible(true);

    dispose();
}
```

Agora o fluxo ficará:

```text
Login correto
    ↓
SessaoUsuario.iniciar
    ↓
FrmPrincipal
    ↓
dispose no FrmLogin
```

---

# 41. Código completo do trecho de autenticação

A parte principal do botão Entrar ficará:

```java
UsuarioDAO usuarioDAO =
        new UsuarioDAO();

Usuario usuario =
        usuarioDAO.autenticar(
                login,
                senha
        );

if (usuario != null) {

    SessaoUsuario.iniciar(usuario);

    FrmPrincipal principal =
            new FrmPrincipal();

    principal.setVisible(true);

    dispose();

} else {

    JOptionPane.showMessageDialog(
            this,
            "Usuário ou senha inválidos."
    );

    txtSenha.setText("");

    txtSenha.requestFocus();
}
```

---

# 42. Código principal da FrmPrincipal

Abaixo temos uma versão organizada da programação manual da nossa classe.

O método `initComponents()` continuará sendo gerado pelo NetBeans.

```java
package view;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.Usuario;
import util.SessaoUsuario;

public class FrmPrincipal
        extends javax.swing.JFrame {

    public FrmPrincipal() {

        initComponents();

        setLocationRelativeTo(null);

        setExtendedState(
                javax.swing.JFrame.MAXIMIZED_BOTH
        );

        carregarUsuario();

        aplicarPermissoes();
    }

    private void carregarUsuario() {

        Usuario usuario =
                SessaoUsuario.getUsuarioLogado();

        if (usuario != null) {

            lblUsuario.setText(
                    "Usuário: "
                    + usuario.getNome()
            );

            lblNivel.setText(
                    "Nível: "
                    + usuario.getNivel()
            );

        } else {

            lblUsuario.setText(
                    "Usuário: não identificado"
            );

            lblNivel.setText(
                    "Nível: não identificado"
            );
        }
    }

    private void aplicarPermissoes() {

        if (SessaoUsuario.isMaster()) {

            mnuUsuarios.setEnabled(true);

            mnuContasPagar.setEnabled(true);

        } else {

            mnuUsuarios.setEnabled(false);

            mnuContasPagar.setEnabled(false);
        }
    }

    private void abrirTela(
            JInternalFrame tela
    ) {

        for (
                JInternalFrame frame :
                desktopPrincipal.getAllFrames()
        ) {

            if (
                    frame.getClass()
                    .equals(
                            tela.getClass()
                    )
            ) {

                try {

                    frame.setSelected(true);

                    if (frame.isIcon()) {

                        frame.setIcon(false);
                    }

                } catch (Exception erro) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Não foi possível selecionar a tela."
                    );
                }

                frame.toFront();

                return;
            }
        }

        desktopPrincipal.add(tela);

        tela.setVisible(true);

        centralizarInternalFrame(tela);
    }

    private void centralizarInternalFrame(
            JInternalFrame tela
    ) {

        int x =
                (
                    desktopPrincipal.getWidth()
                    - tela.getWidth()
                ) / 2;

        int y =
                (
                    desktopPrincipal.getHeight()
                    - tela.getHeight()
                ) / 2;

        if (x < 0) {

            x = 0;
        }

        if (y < 0) {

            y = 0;
        }

        tela.setLocation(x, y);
    }
}
```

---

# 43. Eventos dos menus

Depois de criar os componentes pelo modo Design, nós vamos programar os eventos.

## Clientes

```java
private void mnuClientesActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmCliente()
    );
}
```

## Fornecedores

```java
private void mnuFornecedoresActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmFornecedor()
    );
}
```

## Produtos

```java
private void mnuProdutosActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmProduto()
    );
}
```

## Usuários

```java
private void mnuUsuariosActionPerformed(
        java.awt.event.ActionEvent evt
) {

    if (!SessaoUsuario.isMaster()) {

        JOptionPane.showMessageDialog(
                this,
                "Acesso permitido somente para usuário MASTER."
        );

        return;
    }

    abrirTela(
            new FrmUsuario()
    );
}
```

## Compras

```java
private void mnuComprasActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmCompra()
    );
}
```

## Vendas

```java
private void mnuVendasActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmVenda()
    );
}
```

## Contas a Pagar

```java
private void mnuContasPagarActionPerformed(
        java.awt.event.ActionEvent evt
) {

    if (!SessaoUsuario.isMaster()) {

        JOptionPane.showMessageDialog(
                this,
                "Acesso permitido somente para usuário MASTER."
        );

        return;
    }

    abrirTela(
            new FrmContasPagar()
    );
}
```

## Contas a Receber

```java
private void mnuContasReceberActionPerformed(
        java.awt.event.ActionEvent evt
) {

    abrirTela(
            new FrmContasReceber()
    );
}
```

---

# 44. Testando as permissões com MASTER

Nós vamos iniciar o sistema utilizando:

```text
Login:
master

Senha:
1234
```

Como esse usuário possui:

```text
MASTER
```

ele deverá ter acesso a:

```text
Clientes
Fornecedores
Produtos
Usuários
Compras
Vendas
Contas a Pagar
Contas a Receber
```

Também devemos visualizar:

```text
Usuário: Administrador
```

e:

```text
Nível: MASTER
```

---

# 45. Testando as permissões com USER

Vamos utilizar o usuário de teste:

```text
Login:
user

Senha:
1234
```

A tela deverá abrir normalmente.

Porém:

```text
Usuários
```

deverá ficar desabilitado.

E:

```text
Contas a Pagar
```

também deverá ficar desabilitado.

Os demais recursos operacionais continuarão disponíveis.

---

# 46. Exclusão para USER

Nesta etapa nós ainda não temos os cadastros completos.

Mas já vamos definir uma regra importante.

Dentro de todas as telas que possuírem botão:

```text
Excluir
```

nós vamos aplicar:

```java
btnExcluir.setEnabled(
        SessaoUsuario.isMaster()
);
```

Também vamos validar novamente no evento.

```java
if (!SessaoUsuario.isMaster()) {

    JOptionPane.showMessageDialog(
            this,
            "Você não possui permissão para excluir."
    );

    return;
}
```

Assim o USER não poderá excluir cadastros.

---

# 47. Permissão para Contas a Pagar

O USER poderá realizar uma compra.

Se a compra for parcelada, o sistema poderá criar automaticamente registros na tabela:

```text
contas_pagar
```

Porém o USER não poderá abrir diretamente:

```text
FrmContasPagar
```

Nem poderá dar baixa nessas contas.

Essa operação será exclusiva do MASTER.

---

# 48. Fechando a FrmPrincipal pelo botão da janela

Além do menu Sair, o usuário poderá tentar fechar a janela pelo botão do sistema operacional.

Nós podemos controlar isso adicionando no construtor:

```java
setDefaultCloseOperation(
        javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE
);
```

Depois vamos criar o evento:

```text
windowClosing
```

No NetBeans:

```text
Properties
Events
windowClosing
```

E chamar um método:

```java
confirmarSaida();
```

---

# 49. Criando o método confirmarSaida

```java
private void confirmarSaida() {

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente encerrar o FerragemGK?",
                    "Sair",
                    JOptionPane.YES_NO_OPTION
            );

    if (
            resposta
            == JOptionPane.YES_OPTION
    ) {

        System.exit(0);
    }
}
```

No menu Sair nós também podemos chamar:

```java
confirmarSaida();
```

Assim evitamos repetir código.

---

# 50. Melhorando o evento Sair

Agora o evento poderá ficar:

```java
private void mnuSairActionPerformed(
        java.awt.event.ActionEvent evt
) {

    confirmarSaida();
}
```

E o evento `windowClosing`:

```java
private void formWindowClosing(
        java.awt.event.WindowEvent evt
) {

    confirmarSaida();
}
```

---

# 51. Construtor final da FrmPrincipal

Nosso construtor poderá ficar:

```java
public FrmPrincipal() {

    initComponents();

    setLocationRelativeTo(null);

    setExtendedState(
            javax.swing.JFrame.MAXIMIZED_BOTH
    );

    setDefaultCloseOperation(
            javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE
    );

    carregarUsuario();

    aplicarPermissoes();
}
```

---

# 52. Resumo dos nomes dos componentes

Nós vamos utilizar:

```text
desktopPrincipal

lblUsuario
lblNivel

mnuLogout
mnuSair

mnuClientes
mnuFornecedores
mnuProdutos
mnuUsuarios

mnuCompras
mnuVendas

mnuContasPagar
mnuContasReceber

mnuSobre
```

Usar nomes padronizados facilita bastante a programação dos eventos.

---

# 53. Fluxo completo depois desta etapa

Agora nosso sistema terá:

```text
FrmLogin
    ↓
UsuarioDAO
    ↓
PostgreSQL
    ↓
SessaoUsuario
    ↓
FrmPrincipal
    ↓
carregarUsuario
    ↓
aplicarPermissoes
    ↓
JMenuBar
    ↓
JDesktopPane
    ↓
JInternalFrame
```

---

# 54. O que nós aprendemos nesta etapa

Nesta parte nós trabalhamos com:

```text
JFrame
JMenuBar
JMenu
JMenuItem
JDesktopPane
JInternalFrame
JLabel
JOptionPane
SessaoUsuario
MASTER
USER
Controle de permissões
Logout
Encerramento da aplicação
Abertura de telas internas
Controle de telas duplicadas
Centralização de JInternalFrame
```

---

# 55. Resultado esperado

Ao final desta etapa, nós teremos uma tela principal capaz de:

```text
Receber o usuário autenticado
Mostrar nome e nível
Aplicar permissões
Bloquear Usuários para USER
Bloquear Contas a Pagar para USER
Exibir menus
Abrir telas internas
Evitar JInternalFrame duplicado
Restaurar telas minimizadas
Realizar logout
Voltar para FrmLogin
Confirmar o encerramento do sistema
```

---

# 56. Estrutura visual esperada

Nossa aplicação deverá ficar aproximadamente assim:

```text
==============================================================

Sistema   Cadastros   Movimentos   Financeiro   Ajuda

==============================================================


                    JDesktopPane


          As telas internas serão abertas aqui


==============================================================

Usuário: Administrador                     Nível: MASTER

==============================================================
```

---

# 57. Próxima etapa

Na próxima etapa nós vamos criar o nosso primeiro cadastro completo utilizando o padrão que será repetido em praticamente todo o FerragemGK.

Nós vamos desenvolver:

```text
FrmCliente
```

Ela será um:

```text
JInternalFrame
```

e terá um:

```text
JTabbedPane
```

com duas abas:

```text
Cadastro
Consulta
```

Nós vamos desenvolver juntos:

```text
Classe Cliente
ClienteDAO
Cadastro
Consulta
JTable
Filtro com JComboBox
Pesquisa parcial
Localizar
Alterar
Excluir
Controle de permissão MASTER e USER
Seleção do registro na JTable
Preenchimento automático dos campos
```

Essa próxima etapa será o nosso primeiro CRUD completo dentro da estrutura principal do FerragemGK.
