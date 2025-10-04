import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriadorTabela {
    public static void main(String[] args) throws SQLException {
        try (Connection conexao = ConexaoDB.conectar();
             Statement stmt = conexao.createStatement()) {
            String comandosql = "CREATE TABLE produtos(" +
                    "id_produto INTEGER PRIMARY KEY, " +
                    "nome_produto TEXT NOT NULL, " +
                    "qunatidade INTEGER," +
                    "preco REAL, " +
                    "status TEXT" +
                    ");";
            System.out.println(comandosql);

            stmt.execute(comandosql);

            System.out.println("Tabela 'Produtos' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();


        }


    }

}
