import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private final Connection CONEXAO_DB;


    public ProdutoDAO(Connection conexao) {
        CONEXAO_DB = conexao;
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produtos(nome_produto, quantidade, preco, status) VALUES(?," +
                "?, ?, ?)";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.getStatus());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void excluirTodos(){
        String sql = "DELETE FROM produtos;";
        try(PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)){
            stmt.executeUpdate();
        }catch (SQLException e){
            System.err.println(("Erro ao excluir todos os produtos: " + e.getMessage()));
        }
    }


}
