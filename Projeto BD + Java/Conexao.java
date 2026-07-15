
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;


public class Conexao {
    
    public static Connection conectar() {
       Connection conexao = null;
       
       String url = "jdbc:postgresql://localhost/Escola";
        String usuario = "postgres";
        String senha = "root";
        
         try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao realizada com sucesso!");
      
        } catch (SQLException erro) {
            System.out.println("Erro ao conectar.");
            System.out.println(erro.getMessage());
        }
        
      return conexao;  
    }
    
    public static Connection Cadastrar(){
        Scanner entrada = new Scanner(System.in);
        
       Connection conexao = null;
       
       String url = "jdbc:postgresql://localhost/Escola";
        String usuario = "postgres";
        String senha = "root";
        
         try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao realizada com sucesso!");
                        
            String sql = "INSERT INTO aluno(nome,turma,email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
        System.out.println("=================================");
        System.out.println("CADASTRO DE ALUNO");
        System.out.println("=================================");

        System.out.print("Nome: ");
        String nome = entrada.nextLine();

        System.out.print("Turma: ");
        String turma = entrada.nextLine();

        System.out.print("e-mail: ");
        String email = entrada.nextLine();

            stmt.setString(1, nome);
            stmt.setString(2, turma);
            stmt.setString(3, email);

            int linhas = stmt.executeUpdate();

            System.out.println("Linhas inseridas: " + linhas);
            System.out.println("Aluno cadastrado com sucesso!");

            stmt.close();
            conexao.close();
       
        } catch (SQLException erro) {
            System.out.println("Erro ao conectar.");
            System.out.println(erro.getMessage());
        }
        
      return conexao;        
    }
    
    public static void alterar(){
            String sql = """
                         UPDATE aluno
                         Set nome = ?, turma = ?, email = ?
                         WHERE id = ?
                         """;
            try {
                Connection conexao = conectar();
                
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
                stmt.setString(1,"Joana Silva");
                stmt.setString(2,"Turma 25 2N");
                stmt.setString(3,"joana@email.com");
                stmt.setInt(4, 7);
                
                int linhas = stmt.executeUpdate();
                System.out.println("Registros alterado: "+linhas);
                
                stmt.close();
                conexao.close();
                
            }
            catch (SQLException erro) {
                System.out.println("erro ao algterar o aluno");
                System.out.println(erro.getMessage());
            }
    }
    
    public static void alterarNEW() {

    Scanner entrada = new Scanner(System.in);

    String sql = """
                 UPDATE aluno
                 SET nome = ?, turma = ?, email = ?
                 WHERE id = ?
                 """;

    try {

        Connection conexao = Conexao.conectar();

        System.out.println("=================================");
        System.out.println("ALTERACAO DE ALUNO");
        System.out.println("=================================");

        System.out.print("Digite o ID do aluno: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Novo nome: ");
        String nome = entrada.nextLine();

        System.out.print("Nova turma: ");
        String turma = entrada.nextLine();

        System.out.print("Novo e-mail: ");
        String email = entrada.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, turma);
        stmt.setString(3, email);
        stmt.setInt(4, id);

        int linhasAlteradas = stmt.executeUpdate();

        if (linhasAlteradas > 0) {

            System.out.println();
            System.out.println("Aluno alterado com sucesso!");
            System.out.println("----------------------------");
            System.out.println("ID........: " + id);
            System.out.println("Nome......: " + nome);
            System.out.println("Turma.....: " + turma);
            System.out.println("E-mail....: " + email);

        } else {

            System.out.println();
            System.out.println("Nenhum aluno encontrado com o ID informado.");

        }

        stmt.close();
        conexao.close();

    } catch (SQLException erro) {

        System.out.println("Erro ao alterar aluno.");
        System.out.println(erro.getMessage());

    }

    entrada.close();
}
    
    
     public static void apagar(){
            Scanner entrada = new Scanner (System.in);
            
            String sql = """
                         DELETE FROM aluno
                         WHERE id = ?;
                         """
                         ;
            try {
                Connection conexao = conectar();
                
                PreparedStatement stmt = conexao.prepareStatement(sql);
                
                System.out.println("=================================");
                System.out.println("EXCLUSAO DE ALUNO");
                System.out.println("=================================");

                System.out.print("Digite o ID do aluno: ");
                int id = entrada.nextInt();
                entrada.nextLine();
                
                stmt.setInt(1, id);
                
                int linhas = stmt.executeUpdate();
                System.out.println("Registros Apagados: "+linhas);
                
                stmt.close();
                conexao.close();
                
            }
            catch (SQLException erro) {
                System.out.println("erro ao Apagar o aluno");
                System.out.println(erro.getMessage());
            }
     }
     
     public static void buscarAluno(){
        Scanner entrada = new Scanner (System.in);
        
        System.out.print("Digite o ID do aluno: ");
        int id = entrada.nextInt();
        
        String sql = "SELECT * FROM aluno WHERE id = ?";
        
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1,id);
            
            ResultSet resultado = stmt.executeQuery();
            
            if (resultado.next()){
                System.out.println("Aluno encontrado!");
                System.out.println("ID: " + resultado.getInt("id"));
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Turma: " + resultado.getString("turma"));
                System.out.println("email: " + resultado.getString("email"));
            } else {
                System.out.println("Aluno não encontrado!");
            }
            
                resultado.close();
                stmt.close();
                conexao.close();
        } catch (SQLException erro){
            System.out.println("Erro ao Buscar aluno");
            System.out.println(erro.getMessage());
        }
       entrada.close();
     }
    
   public static void listarAlunos(){
      String sql = "SELECT * FROM aluno ORDER BY id" ;
      try {
          Connection conexao = conectar();
          PreparedStatement stmt = conexao.prepareStatement(sql);
          ResultSet resultado = stmt.executeQuery();
          
          System.out.println();
          System.out.println("===========================");
          System.out.println("    ALUNOS CADASTRADOS");
          System.out.println("===========================");
          
          boolean encontrouAluno = false;
          
          while(resultado.next()){
              encontrouAluno = true;
              
              System.out.println("ID: " + resultado.getInt("id"));
              System.out.println("Nome: " + resultado.getString("nome"));
              System.out.println("Turma: " + resultado.getString("turma"));
              System.out.println("Email: " + resultado.getString("email"));
              System.out.println("------------------------------");
          }
          
          if (!encontrouAluno){
              System.out.println("Nenhum aluno Cadastrado.");
          }
          
          resultado.close();
          stmt.close();
          conexao.close();
      } catch (SQLException erro){
            System.out.println("Erro ao Buscar aluno");
            System.out.println(erro.getMessage());
        }
   }  
}  

