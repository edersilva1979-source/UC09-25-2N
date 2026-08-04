import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Aluno {
    
    private int id;
    private String nome;
    private String turma;
    private String email;
    
    public Aluno(){
    }
    
    public Aluno(int id, String nome, String turma, String email){
        this.id = id;
        this.nome = nome;
        this.turma = turma;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
    
    public boolean cadastrar(String nome, String turma, String email){
      String sql = "INSERT INTO aluno "
                   + "(nome,turma,email) "
                   + "VALUES (?,?,?)";
      
      try {
          Connection conexao = Conexao.conectar();
          if (conexao == null){
          System.out.println("Não foi possivel conectar");
          return false;
          }
          
          PreparedStatement stmt = conexao.prepareStatement(sql);
          stmt.setString(1,nome);
          stmt.setString(2,turma);
          stmt.setString(3,email);
          
          int linhas = stmt.executeUpdate();
          stmt.close();
          conexao.close();
          return linhas > 0;
          
    } catch (SQLException erro){
            System.out.println(" Não Foi possivel Cadastrar este aluno");
            System.out.println(erro.getMessage());
            return false;
    }  
    }
    
    public ArrayList<Aluno> listar(){
    
            ArrayList<Aluno> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM aluno ORDER BY id";
            
            try {
                Connection conexao = Conexao.conectar();
                
                if (conexao == null){
                    return lista;
                }
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();
                
                while (resultado.next()){
                    Aluno aluno = new Aluno();
                    aluno.setId(resultado.getInt("id"));
                    aluno.setNome(resultado.getString("nome"));
                    aluno.setTurma(resultado.getString("turma"));
                    aluno.setEmail(resultado.getString("email"));
                    
                    lista.add(aluno);
                }
                resultado.close();
                stmt.close();
                conexao.close();
            } 
            catch (SQLException erro){
               System.out.println("Erro ao Listar Alunos");
               System.out.println(erro.getMessage());
            }
            return lista;
    } 
    
    public Aluno buscarPorId(int id){
        String sql = "SELECT * FROM aluno WHERE id = ?";
        
        try{
            Connection conexao = Conexao.conectar();
            if (conexao == null){
                return null;
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet resultado = stmt.executeQuery();
            
            if (resultado.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setTurma(resultado.getString("turma"));
                aluno.setEmail(resultado.getString("email"));
                        
                resultado.close();
                stmt.close();
                conexao.close();
            
                return aluno;
            }
            
        }
        catch (SQLException erro) {
            System.out.println("Erro ao buscar aluno.");
            System.out.println(erro.getMessage());
        }
        
        return null;
    }
    
    
    public ArrayList<Aluno> localizar(String tipo, String valor){
    
        ArrayList<Aluno> lista = new ArrayList<>();
        
        String sql;
        
        switch (tipo){
            
            case"ID":
                sql = """
                      SELECT id, nome, turma,email FROM aluno
                      WHERE id = ?
                      ORDER BY id
                      """;
                break;
                
            case "Nome":
                sql = """
                      SELECT id, nome, turma, email FROM aluno
                      WHERE nome ILIKE ?
                      OREDER BY turma, nome
                      """;
                break;
            case "Turma":
                sql = """
                      SELECT id, nome, turma,email FROM aluno
                      WHERE turma ILIKE ?
                      ORDER BY turma, nome
                      """;
            break ;
            
            case "Email":
                sql = """
                      SELECT id, nome, turma, email FROM aluno
                      WHERE email ILIKE ?
                      ORDER BY email
                      """;
                break;
                
            default: return lista;    
        }
        
        try {
            
            Connection conexao = Conexao.conectar();
            
            if (conexao == null) {
                return lista;
            }
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            if (tipo.equals("Id")) {
               int id = Integer.parseInt(valor);
               stmt.setInt(1,id);
            } else {
               stmt.setString(1, "%" + valor + "%");
            }
            
            ResultSet resultado = stmt.executeQuery();
            
            while (resultado.next()){
                Aluno aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setTurma(resultado.getString("turma"));
                aluno.setEmail(resultado.getString("email"));
                
                lista.add(aluno);
            }
            resultado.close();
            stmt.close();
            conexao.close();
        } 
        
        catch ( NumberFormatException erro){
              System.out.println("O ID deve conter apenas números");
        } 
        
        catch (SQLException erro) {
            System.out.println("Erro ao localizar aluno: " + erro.getMessage());
        } 
        return lista;
    }
    
    
    public boolean alterar(int id, String nome, String turma, String email){
        String sql = "UPDATE aluno "
                    + "SET nome = ?, turma = ?, email = ? "
                    + "WHERE id = ?";
        
        try {
            Connection conexao = Conexao.conectar();
            if (conexao == null){
                return false;
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,nome);
            stmt.setString(2,turma);
            stmt.setString(3,email);
            stmt.setInt(4, id);
            
            int linhas = stmt.executeUpdate();
            stmt.close();
            conexao.close();  
            return linhas > 0;
        }
        catch( SQLException erro){
            System.out.println("Erro ao Alterar aluno");
            System.out.println(erro.getMessage());
            return false;
        }
            
        }
   
    public boolean excluir(int id){
        String sql = "DELETE FROM aluno WHERE id = ?";
        try {
            Connection conexao = Conexao.conectar();
            if (conexao == null){
                return false;
            }
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            
            int linhas = stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            return linhas > 0;
        }
        catch (SQLException erro){
            System.out.println("Erro ao Excluir Aluno");
            System.out.println(erro.getMessage());
            return false;
        }
        }
            
        
    }
   
