import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Model da entidade Categoria.
 */
public class CategoriaModel {

    public static void create(CategoriaBean c, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO Categoria (id, nome, descricao) VALUES (?,?,?)");
        st.setInt(1, c.getId());
        st.setString(2, c.getNome());
        st.setString(3, c.getDescricao());
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM Categoria WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static HashSet<CategoriaBean> listAll(Connection con) throws SQLException {
        HashSet<CategoriaBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT id, nome, descricao FROM Categoria";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new CategoriaBean(result.getInt(1), result.getString(2), result.getString(3)));
        }
        st.close();
        return list;
    }
}
