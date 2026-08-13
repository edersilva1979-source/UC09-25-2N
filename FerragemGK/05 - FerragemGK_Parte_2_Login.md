# Projeto FerragemGK
<div align="center">
<img src="Logo.png" width="200" alt="Exemplo">
</div>
# Parte 2: Criando o Login com Java Swing e PostgreSQL

Nesta etapa, nós vamos criar juntos o primeiro módulo funcional do nosso sistema FerragemGK.

Nós vamos desenvolver:

* A classe de conexão com o PostgreSQL
* A classe `Usuario`
* A classe `UsuarioDAO`
* A classe `SessaoUsuario`
* A tela `FrmLogin`
* O método de autenticação
* O botão Entrar
* O botão Sair
* A validação do usuário
* A validação da senha
* O controle de usuário ativo
* O início do controle de níveis MASTER e USER

Ao final desta etapa, nós já teremos uma aplicação capaz de consultar o banco PostgreSQL, validar login e senha e armazenar os dados do usuário conectado.

---

# 1. Estrutura inicial do projeto

Nós vamos organizar nosso projeto utilizando pacotes.

A estrutura ficará assim:

```text
FerragemGK

conexao
    Conexao.java

model
    Usuario.java

dao
    UsuarioDAO.java

util
    SessaoUsuario.java

view
    FrmLogin.java
```

Cada pacote terá uma responsabilidade específica.

Isso nos ajuda a evitar que toda a programação fique concentrada dentro das telas.

---

# 2. Usuário inicial do sistema

No script de criação do banco nós já cadastramos um usuário MASTER.

Nós vamos utilizar esse usuário para testar nossa tela de login.

```text
Nome: Administrador
Login: master
Senha: 1234
Nível: MASTER
Ativo: true
```

Podemos verificar diretamente no PostgreSQL utilizando:

```sql
SELECT *
FROM usuario;
```

Se o registro aparecer corretamente, nós podemos continuar.

---

# 3. Criando a classe Conexao

Se ainda não tivermos criado a classe de conexão, nós vamos criar o pacote:

```text
conexao
```

Depois criaremos:

```text
Conexao.java
```

Código:

```java
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/FerragemGK";

    private static final String USUARIO = "postgres";

    private static final String SENHA = "SUA_SENHA_POSTGRES";

    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );
    }
}
```

Nós devemos substituir:

```text
SUA_SENHA_POSTGRES
```

pela senha configurada no PostgreSQL.

Por exemplo:

```java
private static final String SENHA = "1234";
```

---

# 4. Entendendo a URL de conexão

A linha:

```java
jdbc:postgresql://localhost:5432/FerragemGK
```

possui várias informações.

```text
jdbc:postgresql
```

indica que nós estamos utilizando JDBC com PostgreSQL.

```text
localhost
```

indica que o PostgreSQL está instalado no mesmo computador.

```text
5432
```

é a porta padrão do PostgreSQL.

```text
FerragemGK
```

é o nome do nosso banco.

---

# 5. Adicionando o Driver PostgreSQL

Antes de testar a conexão, nós precisamos garantir que o Driver JDBC do PostgreSQL esteja disponível no projeto.

No NetBeans, nós vamos localizar:

```text
Libraries
```

ou, dependendo da versão:

```text
Dependencies
```

O projeto precisa possuir o driver JDBC do PostgreSQL.

Sem ele, o Java não conseguirá conversar com o banco.

---

# 6. Criando a classe Usuario

Agora nós vamos criar o pacote:

```text
model
```

Dentro dele criaremos:

```text
Usuario.java
```

A classe `Usuario` representará um registro da tabela `usuario`.

Código completo:

```java
package model;

public class Usuario {

    private long idUsuario;
    private String nome;
    private String login;
    private String senha;
    private String nivel;
    private boolean ativo;

    public Usuario() {
    }

    public Usuario(
            long idUsuario,
            String nome,
            String login,
            String senha,
            String nivel,
            boolean ativo
    ) {

        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
```

---

# 7. Entendendo os atributos da classe Usuario

Nós criamos:

```java
private long idUsuario;
```

para guardar o código do usuário.

```java
private String nome;
```

para guardar o nome completo.

```java
private String login;
```

para guardar o login utilizado na tela.

```java
private String senha;
```

para guardar a senha.

```java
private String nivel;
```

para identificar se o usuário é:

```text
MASTER
```

ou:

```text
USER
```

E:

```java
private boolean ativo;
```

para identificar se o usuário pode ou não acessar o sistema.

---

# 8. Criando a classe UsuarioDAO

Agora nós vamos criar o pacote:

```text
dao
```

Dentro dele criaremos:

```text
UsuarioDAO.java
```

Essa classe será responsável por consultar a tabela `usuario`.

Código completo:

```java
package dao;

import conexao.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario autenticar(
            String login,
            String senha
    ) {

        String sql =
                "SELECT id_usuario, nome, login, nivel, ativo "
                + "FROM usuario "
                + "WHERE login = ? "
                + "AND senha = ? "
                + "AND ativo = TRUE";

        try (
                Connection conexao = Conexao.conectar();

                PreparedStatement stmt =
                        conexao.prepareStatement(sql)
        ) {

            stmt.setString(1, login);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Usuario usuario = new Usuario();

                    usuario.setIdUsuario(
                            rs.getLong("id_usuario")
                    );

                    usuario.setNome(
                            rs.getString("nome")
                    );

                    usuario.setLogin(
                            rs.getString("login")
                    );

                    usuario.setNivel(
                            rs.getString("nivel")
                    );

                    usuario.setAtivo(
                            rs.getBoolean("ativo")
                    );

                    return usuario;
                }
            }

        } catch (SQLException erro) {

            throw new RuntimeException(
                    "Erro ao autenticar usuário.",
                    erro
            );
        }

        return null;
    }
}
```

---

# 9. Método autenticar

O principal método dessa classe será:

```java
public Usuario autenticar(
        String login,
        String senha
)
```

Ele receberá dois valores:

```text
login
senha
```

Depois consultará o banco.

Se encontrar o usuário, devolverá um objeto `Usuario`.

Se não encontrar, devolverá:

```java
null
```

---

# 10. Consulta SQL do login

Nós vamos utilizar:

```sql
SELECT
    id_usuario,
    nome,
    login,
    nivel,
    ativo
FROM usuario
WHERE login = ?
AND senha = ?
AND ativo = TRUE;
```

Os símbolos:

```text
?
```

serão preenchidos pelo `PreparedStatement`.

---

# 11. Preenchendo o PreparedStatement

Nós vamos utilizar:

```java
stmt.setString(1, login);
```

para preencher o primeiro ponto de interrogação.

E:

```java
stmt.setString(2, senha);
```

para preencher o segundo.

Se o usuário digitar:

```text
master
```

e:

```text
1234
```

essas informações serão enviadas ao PostgreSQL.

---

# 12. Por que utilizar PreparedStatement

Nós não vamos montar a consulta concatenando diretamente o texto digitado pelo usuário.

Nós vamos utilizar:

```java
PreparedStatement
```

Essa abordagem é mais organizada e reduz riscos relacionados à montagem manual de comandos SQL.

Além disso, nós vamos utilizar `PreparedStatement` em praticamente todo o sistema FerragemGK.

---

# 13. ResultSet

Depois de executar:

```java
ResultSet rs = stmt.executeQuery();
```

o PostgreSQL devolverá os registros encontrados.

Nós verificamos:

```java
if (rs.next())
```

Se existir um registro, nós criamos:

```java
Usuario usuario = new Usuario();
```

Depois preenchemos seus atributos.

---

# 14. Criando o objeto Usuario

Nós vamos carregar os dados retornados pelo banco.

```java
usuario.setIdUsuario(
        rs.getLong("id_usuario")
);
```

```java
usuario.setNome(
        rs.getString("nome")
);
```

```java
usuario.setLogin(
        rs.getString("login")
);
```

```java
usuario.setNivel(
        rs.getString("nivel")
);
```

```java
usuario.setAtivo(
        rs.getBoolean("ativo")
);
```

Depois retornamos:

```java
return usuario;
```

---

# 15. Quando o usuário não for encontrado

Se a consulta terminar sem encontrar nenhum registro, nós chegaremos em:

```java
return null;
```

Isso será verificado depois na tela.

---

# 16. Criando a classe SessaoUsuario

Depois do login, nós precisamos guardar quem está conectado.

Vamos criar o pacote:

```text
util
```

Dentro dele:

```text
SessaoUsuario.java
```

Código completo:

```java
package util;

import model.Usuario;

public class SessaoUsuario {

    private static Usuario usuarioLogado;

    public static void iniciar(Usuario usuario) {

        usuarioLogado = usuario;
    }

    public static Usuario getUsuarioLogado() {

        return usuarioLogado;
    }

    public static boolean isMaster() {

        return usuarioLogado != null
                && "MASTER".equalsIgnoreCase(
                        usuarioLogado.getNivel()
                );
    }

    public static boolean isUser() {

        return usuarioLogado != null
                && "USER".equalsIgnoreCase(
                        usuarioLogado.getNivel()
                );
    }

    public static void encerrar() {

        usuarioLogado = null;
    }
}
```

---

# 17. Para que serve a SessaoUsuario

Quando o login estiver correto, nós vamos executar:

```java
SessaoUsuario.iniciar(usuario);
```

Isso significa que o sistema passará a guardar o usuário autenticado.

Depois poderemos recuperar:

```java
Usuario usuario =
        SessaoUsuario.getUsuarioLogado();
```

Também poderemos perguntar:

```java
SessaoUsuario.isMaster();
```

ou:

```java
SessaoUsuario.isUser();
```

Isso será utilizado para controlar as permissões.

---

# 18. Exemplo de permissão

Mais adiante, em uma tela de cadastro, nós poderemos fazer:

```java
if (SessaoUsuario.isMaster()) {

    btnExcluir.setEnabled(true);

} else {

    btnExcluir.setEnabled(false);
}
```

Assim, somente o MASTER poderá excluir registros.

---

# 19. Criando a tela FrmLogin

Agora nós vamos criar a parte visual.

No pacote:

```text
view
```

vamos clicar com o botão direito.

Depois:

```text
New
```

e:

```text
JFrame Form
```

O nome será:

```text
FrmLogin
```

---

# 20. Componentes da tela

Nós vamos inserir:

```text
JLabel
JTextField
JPasswordField
JButton
```

Nossa tela poderá ficar semelhante a:

```text
====================================

            FERRAGEM GK

              LOGIN

Usuário:
[                              ]

Senha:
[                              ]

       [ Entrar ]    [ Sair ]

====================================
```

---

# 21. Nomeando os componentes

No NetBeans, nós devemos alterar a propriedade `Variable Name`.

Campo de login:

```text
txtLogin
```

Campo de senha:

```text
txtSenha
```

Botão Entrar:

```text
btnEntrar
```

Botão Sair:

```text
btnSair
```

---

# 22. Tipo de cada campo

O campo:

```text
txtLogin
```

será um:

```text
JTextField
```

O campo:

```text
txtSenha
```

será um:

```text
JPasswordField
```

Assim, a senha aparecerá mascarada na tela.

Exemplo:

```text
****
```

---

# 23. Configurando a janela

Nós podemos definir o título como:

```text
FerragemGK Login
```

Também podemos impedir que a janela seja redimensionada.

No construtor:

```java
public FrmLogin() {

    initComponents();

    setLocationRelativeTo(null);

    setResizable(false);

    getRootPane().setDefaultButton(btnEntrar);
}
```

---

# 24. Centralizando a tela

A instrução:

```java
setLocationRelativeTo(null);
```

faz com que a tela de login seja aberta no centro do monitor.

---

# 25. Impedindo redimensionamento

Nós utilizamos:

```java
setResizable(false);
```

Assim, a tela terá tamanho fixo.

---

# 26. Definindo o botão padrão

Nós vamos utilizar:

```java
getRootPane().setDefaultButton(btnEntrar);
```

Isso significa que, depois de digitar usuário e senha, nós poderemos pressionar:

```text
ENTER
```

e o botão Entrar será acionado.

---

# 27. Imports da FrmLogin

No início da classe nós vamos precisar:

```java
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import util.SessaoUsuario;
```

A estrutura inicial ficará:

```java
package view;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import util.SessaoUsuario;

public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {

        initComponents();

        setLocationRelativeTo(null);

        setResizable(false);

        getRootPane().setDefaultButton(btnEntrar);
    }
}
```

---

# 28. Programando o botão Entrar

No modo Design do NetBeans, nós vamos clicar duas vezes sobre:

```text
btnEntrar
```

O NetBeans criará um método semelhante a:

```java
private void btnEntrarActionPerformed(
        java.awt.event.ActionEvent evt
)
```

Dentro dele nós vamos programar a autenticação.

Código completo:

```java
private void btnEntrarActionPerformed(
        java.awt.event.ActionEvent evt
) {

    String login =
            txtLogin.getText().trim();

    String senha =
            new String(
                    txtSenha.getPassword()
            );

    if (login.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe o usuário."
        );

        txtLogin.requestFocus();

        return;
    }

    if (senha.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Informe a senha."
        );

        txtSenha.requestFocus();

        return;
    }

    try {

        UsuarioDAO usuarioDAO =
                new UsuarioDAO();

        Usuario usuario =
                usuarioDAO.autenticar(
                        login,
                        senha
                );

        if (usuario != null) {

            SessaoUsuario.iniciar(usuario);

            JOptionPane.showMessageDialog(
                    this,
                    "Bem vindo, "
                    + usuario.getNome()
                    + "!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuário ou senha inválidos."
            );

            txtSenha.setText("");

            txtSenha.requestFocus();
        }

    } catch (Exception erro) {

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível realizar o login.\n"
                + erro.getMessage()
        );
    }
}
```

---

# 29. Pegando o login digitado

Nós utilizamos:

```java
String login =
        txtLogin.getText().trim();
```

O método:

```java
getText()
```

pega o conteúdo digitado.

O método:

```java
trim()
```

remove espaços desnecessários no início e no final.

---

# 30. Pegando a senha digitada

Como estamos utilizando `JPasswordField`, nós fazemos:

```java
String senha =
        new String(
                txtSenha.getPassword()
        );
```

O método:

```java
getPassword()
```

retorna um vetor de caracteres.

Por isso nós transformamos em `String`.

---

# 31. Validando o campo login

Nós verificamos:

```java
if (login.isEmpty())
```

Se o campo estiver vazio, exibimos:

```java
JOptionPane.showMessageDialog(
        this,
        "Informe o usuário."
);
```

Depois:

```java
txtLogin.requestFocus();
```

manda o cursor de volta ao campo.

---

# 32. Validando o campo senha

Nós também verificamos:

```java
if (senha.isEmpty())
```

Se estiver vazio:

```java
JOptionPane.showMessageDialog(
        this,
        "Informe a senha."
);
```

Depois colocamos o cursor no campo de senha.

---

# 33. Criando o UsuarioDAO

Dentro do botão nós fazemos:

```java
UsuarioDAO usuarioDAO =
        new UsuarioDAO();
```

Agora nós temos um objeto capaz de consultar a tabela `usuario`.

---

# 34. Chamando o método autenticar

Nós executamos:

```java
Usuario usuario =
        usuarioDAO.autenticar(
                login,
                senha
        );
```

Se o banco encontrar o usuário, a variável `usuario` receberá um objeto.

Se não encontrar, receberá:

```java
null
```

---

# 35. Login correto

Nós verificamos:

```java
if (usuario != null)
```

Se for diferente de `null`, significa que o login foi aceito.

Então iniciamos a sessão:

```java
SessaoUsuario.iniciar(usuario);
```

E mostramos:

```java
JOptionPane.showMessageDialog(
        this,
        "Bem vindo, "
        + usuario.getNome()
        + "!"
);
```

---

# 36. Login incorreto

Se o usuário não for encontrado, nós exibimos:

```java
JOptionPane.showMessageDialog(
        this,
        "Usuário ou senha inválidos."
);
```

Depois limpamos a senha:

```java
txtSenha.setText("");
```

E colocamos o cursor novamente no campo:

```java
txtSenha.requestFocus();
```

---

# 37. Tratamento de erro

Nós utilizamos:

```java
try
```

e:

```java
catch
```

para tratar problemas.

Por exemplo:

```text
PostgreSQL desligado
Banco inexistente
Senha do PostgreSQL incorreta
Driver não configurado
Erro na consulta
```

No `catch` nós mostramos:

```java
JOptionPane.showMessageDialog(
        this,
        "Não foi possível realizar o login.\n"
        + erro.getMessage()
);
```

---

# 38. Programando o botão Sair

Agora nós vamos clicar duas vezes sobre:

```text
btnSair
```

E escrever:

```java
private void btnSairActionPerformed(
        java.awt.event.ActionEvent evt
) {

    int resposta =
            JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente sair?",
                    "FerragemGK",
                    JOptionPane.YES_NO_OPTION
            );

    if (resposta ==
            JOptionPane.YES_OPTION) {

        System.exit(0);
    }
}
```

---

# 39. Confirmando antes de fechar

Nós utilizamos:

```java
JOptionPane.showConfirmDialog
```

para perguntar se o usuário realmente deseja sair.

Se ele escolher:

```text
Sim
```

o sistema executará:

```java
System.exit(0);
```

---

# 40. Método main

O NetBeans normalmente cria o método `main` automaticamente.

Ele poderá ficar semelhante a:

```java
public static void main(String args[]) {

    java.awt.EventQueue.invokeLater(
            new Runnable() {

                public void run() {

                    new FrmLogin()
                            .setVisible(true);
                }
            }
    );
}
```

Isso faz com que a aplicação comece exibindo o login.

---

# 41. Testando o usuário MASTER

Nós vamos executar o projeto.

Depois digitaremos:

```text
Login:
master
```

```text
Senha:
1234
```

O resultado esperado será:

```text
Bem vindo, Administrador!
```

Se essa mensagem aparecer, nosso fluxo está funcionando.

---

# 42. Fluxo da autenticação

O processo completo será:

```text
FrmLogin
    ↓
Usuário digita login e senha
    ↓
Botão Entrar
    ↓
UsuarioDAO
    ↓
Conexao
    ↓
PostgreSQL
    ↓
Tabela usuario
    ↓
Registro encontrado
    ↓
Objeto Usuario
    ↓
SessaoUsuario
    ↓
Acesso autorizado
```

---

# 43. Testando senha incorreta

Nós podemos testar:

```text
Login:
master
```

```text
Senha:
9999
```

O resultado deverá ser:

```text
Usuário ou senha inválidos.
```

---

# 44. Testando usuário inativo

No PostgreSQL, nós podemos executar:

```sql
UPDATE usuario
SET ativo = FALSE
WHERE login = 'master';
```

Depois tentamos entrar novamente.

Mesmo utilizando a senha correta, o sistema deverá negar o acesso.

Isso acontece porque nossa consulta possui:

```sql
AND ativo = TRUE
```

Depois do teste, nós vamos reativar o usuário:

```sql
UPDATE usuario
SET ativo = TRUE
WHERE login = 'master';
```

---

# 45. Criando um usuário USER para teste

Nós também podemos criar um usuário comum.

```sql
INSERT INTO usuario (
    nome,
    login,
    senha,
    nivel,
    ativo
)
VALUES (
    'Usuario Teste',
    'user',
    '1234',
    'USER',
    TRUE
);
```

Agora nós teremos dois usuários.

```text
MASTER

Login:
master

Senha:
1234
```

E:

```text
USER

Login:
user

Senha:
1234
```

Isso será importante quando começarmos a trabalhar com permissões.

---

# 46. Preparando a abertura da FrmPrincipal

Por enquanto nós podemos apenas mostrar a mensagem de boas vindas.

Quando criarmos a tela principal, vamos substituir esta parte:

```java
JOptionPane.showMessageDialog(
        this,
        "Bem vindo, "
        + usuario.getNome()
        + "!"
);
```

pela abertura da tela principal.

O código será:

```java
FrmPrincipal principal =
        new FrmPrincipal();

principal.setVisible(true);

dispose();
```

O trecho completo ficará:

```java
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

# 47. Para que serve dispose

Nós utilizamos:

```java
dispose();
```

para fechar a tela de login depois que a tela principal for aberta.

Assim, o usuário não ficará com duas janelas abertas desnecessariamente.

---

# 48. Sobre o código gerado pelo NetBeans

Quando nós criamos um `JFrame Form`, o NetBeans gera automaticamente o método:

```java
initComponents();
```

Esse método contém grande parte da configuração visual.

Nós não devemos alterar manualmente o conteúdo gerado pelo editor visual sem necessidade.

Nós vamos trabalhar principalmente com:

```text
Eventos
Métodos
Classes
Regras de negócio
```

---

# 49. Observação sobre senha

Nesta primeira versão, nós estamos armazenando a senha diretamente no banco.

Exemplo:

```text
1234
```

Isso foi escolhido para facilitar o aprendizado inicial.

Nós queremos primeiro compreender:

```text
JDBC
PreparedStatement
ResultSet
Autenticação
Sessão
Permissões
```

Em uma aplicação real, nós não devemos armazenar senhas dessa forma.

Mais adiante, nós poderemos evoluir o projeto utilizando hash de senha.

---

# 50. JPasswordField não criptografa a senha

O componente:

```text
JPasswordField
```

apenas mascara visualmente os caracteres digitados.

Por exemplo:

```text
****
```

Ele não criptografa a senha armazenada no banco.

Essa diferença é importante.

---

# 51. Estrutura final desta etapa

Depois de concluir o login, nosso projeto terá:

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
```

---

# 52. O que nós aprendemos nesta etapa

Nós trabalhamos com:

```text
JFrame
JTextField
JPasswordField
JButton
JOptionPane
JDBC
Connection
PreparedStatement
ResultSet
DAO
Classe Usuario
SessaoUsuario
Validação
Login
Senha
Usuário ativo
MASTER
USER
Tratamento de erros
```

---

# 53. Resultado esperado

Ao final desta etapa, nós teremos um login funcionando de verdade.

O sistema será capaz de:

```text
Receber usuário e senha

Validar campos vazios

Consultar o PostgreSQL

Verificar usuário ativo

Identificar MASTER ou USER

Criar um objeto Usuario

Guardar o usuário na sessão

Aceitar login correto

Recusar login incorreto

Preparar a abertura da tela principal
```

---

# 54. Próxima etapa

Na próxima etapa, nós vamos criar a:

```text
FrmPrincipal
```

Ela será a tela central do FerragemGK.

Nós vamos desenvolver:

```text
JFrame principal
JMenuBar
Menus
Submenus
JDesktopPane
JInternalFrame
Identificação do usuário conectado
Controle de permissões
Bloqueio de menus para USER
Abertura das telas internas
```

O MASTER poderá visualizar todos os recursos.

O USER já começará com recursos restritos, principalmente exclusões, administração de usuários e contas a pagar.

Nós vamos fazer essa evolução juntos, mantendo o sistema organizado e entendendo cada parte antes de avançar.
