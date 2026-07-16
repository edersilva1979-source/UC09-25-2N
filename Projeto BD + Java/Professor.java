import src.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Professor {

    Scanner entrada = new Scanner(System.in);

    // ==========================
    // CADASTRAR
    // ==========================
    public void cadastrar() {

        String sql = """
                     INSERT INTO professor
                     (nome, cpf, telefone, disciplina)
                     VALUES (?, ?, ?, ?)
                     """;

        try {

            Connection conexao = Conexao.conectar();

            System.out.println("=== CADASTRO DE PROFESSOR ===");

            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            
            System.out.print("CPF: ");
            String cpf = entrada.nextLine();
            
            System.out.print("Telefone: ");
            String telefone = entrada.nextLine();

            System.out.print("Disciplina: ");
            String disciplina = entrada.nextLine();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, disciplina);
          

            stmt.executeUpdate();

            System.out.println();
            System.out.println("Professor cadastrado com sucesso!");

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {

            System.out.println("Erro ao cadastrar professor.");
            System.out.println(erro.getMessage());

        }
    }

    // ==========================
    // ALTERAR
    // ==========================
    public void alterar() {

        String sql = """
                     UPDATE professor
                     SET nome = ?, cpf = ?, telefone = ?, disciplina = ?, 
                     WHERE id = ?
                     """;

        try {

            Connection conexao = Conexao.conectar();

            System.out.println("=== ALTERAÇÃO DE PROFESSOR ===");

            System.out.print("ID: ");
            int id = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Novo nome: ");
            String nome = entrada.nextLine();
            
             System.out.print("Novo CPF: ");
            String cpf = entrada.nextLine();
            
             System.out.print("Novo telefone: ");
            String telefone = entrada.nextLine();

            System.out.print("Nova disciplina: ");
            String disciplina = entrada.nextLine();

           

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, disciplina);
            stmt.setInt(5, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {

                System.out.println();
                System.out.println("Professor alterado com sucesso!");

            } else {

                System.out.println();
                System.out.println("Professor não encontrado.");

            }

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {

            System.out.println("Erro ao alterar professor.");
            System.out.println(erro.getMessage());

        }
    }

    // ==========================
    // APAGAR
    // ==========================
    public void apagar() {

        String sql =
                "DELETE FROM professor WHERE id = ?";

        try {

            Connection conexao = Conexao.conectar();

            System.out.println("=== EXCLUSÃO DE PROFESSOR ===");

            System.out.print("ID: ");
            int id = entrada.nextInt();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {

                System.out.println();
                System.out.println("Professor excluído com sucesso!");

            } else {

                System.out.println();
                System.out.println("Professor não encontrado.");

            }

            stmt.close();
            conexao.close();

        } catch (SQLException erro) {

            System.out.println("Erro ao excluir professor.");
            System.out.println(erro.getMessage());

        }
    }

    // ==========================
    // LOCALIZAR
    // ==========================
    public void localizarProfessor() {

        String sql =
                "SELECT * FROM professor WHERE id = ?";

        try {

            Connection conexao = Conexao.conectar();

            System.out.println("=== LOCALIZAR PROFESSOR ===");

            System.out.print("ID: ");
            int id = entrada.nextInt();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado =
                    stmt.executeQuery();

            if (resultado.next()) {

                System.out.println();
                System.out.println("Professor encontrado");
                System.out.println("-------------------------");
                System.out.println("ID: " +
                        resultado.getInt("id"));
                System.out.println("Nome: " +
                        resultado.getString("nome"));
                System.out.println("CPF: " +
                        resultado.getString("cpf"));
                System.out.println("Telefone: " +
                        resultado.getString("telefone"));
                System.out.println("Disciplina: " +
                        resultado.getString("disciplina"));
                

            } else {

                System.out.println();
                System.out.println("Professor não encontrado.");

            }

            resultado.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {

            System.out.println("Erro ao localizar professor.");
            System.out.println(erro.getMessage());

        }
    }

    // ==========================
    // LISTAR
    // ==========================
    public void listarProfessor() {

        String sql =
                "SELECT * FROM professor ORDER BY id";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt =
                    conexao.prepareStatement(sql);

            ResultSet resultado =
                    stmt.executeQuery();

            System.out.println();
            System.out.println("===== PROFESSORES =====");

            while (resultado.next()) {

                System.out.println("-------------------------");
                System.out.println("ID: " +
                        resultado.getInt("id"));
                System.out.println("Nome: " +
                        resultado.getString("nome"));
                System.out.println("CPF: " +
                        resultado.getString("cpf"));
                System.out.println("Telefone: " +
                        resultado.getString("telefone"));
                System.out.println("Disciplina: " +
                        resultado.getString("disciplina"));
                

            }

            resultado.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {

            System.out.println("Erro ao listar professores.");
            System.out.println(erro.getMessage());

        }
    }
}
