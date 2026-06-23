import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Model da entidade Alimento.
 */
public class AlimentoModel {

    public static void create(AlimentoBean a, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO Alimento (id, nome, calorias_100g, proteina_100g, carboidrato_100g, gordura_100g, categoria_id) "
                + "VALUES (?,?,?,?,?,?,?)");
        st.setInt(1, a.getId());
        st.setString(2, a.getNome());
        st.setDouble(3, a.getCalorias100g());
        st.setDouble(4, a.getProteina100g());
        st.setDouble(5, a.getCarboidrato100g());
        st.setDouble(6, a.getGordura100g());
        st.setInt(7, a.getCategoriaId());
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM Alimento WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static HashSet<AlimentoBean> listAll(Connection con) throws SQLException {
        HashSet<AlimentoBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT id, nome, calorias_100g, proteina_100g, carboidrato_100g, gordura_100g, categoria_id FROM Alimento";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new AlimentoBean(result.getInt(1), result.getString(2), result.getDouble(3),
                    result.getDouble(4), result.getDouble(5), result.getDouble(6), result.getInt(7)));
        }
        st.close();
        return list;
    }

    /**
     * Consulta com JUNCAO (JOIN) entre Alimento e Categoria.
     */
    public static HashSet<AlimentoBean> listAllWithCategoria(Connection con) throws SQLException {
        HashSet<AlimentoBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT a.id, a.nome, a.calorias_100g, a.proteina_100g, a.carboidrato_100g, "
                + "a.gordura_100g, a.categoria_id, c.id, c.nome, c.descricao "
                + "FROM Alimento a JOIN Categoria c ON a.categoria_id = c.id";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            AlimentoBean a = new AlimentoBean(result.getInt(1), result.getString(2), result.getDouble(3),
                    result.getDouble(4), result.getDouble(5), result.getDouble(6), result.getInt(7));
            CategoriaBean c = new CategoriaBean(result.getInt(8), result.getString(9), result.getString(10));
            a.setCategoria(c);
            list.add(a);
        }
        st.close();
        return list;
    }
}
