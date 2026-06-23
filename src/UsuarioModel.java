import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Model da entidade Usuario: contem as operacoes de acesso ao banco
 * (INSERT, DELETE e SELECT) feitas via JDBC puro (sem frameworks ORM).
 */
public class UsuarioModel {

    public static void create(UsuarioBean u, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO Usuario (id, nome, peso_atual, altura, meta_calorica, meta_proteina, objetivo) "
                + "VALUES (?,?,?,?,?,?,?)");
        st.setInt(1, u.getId());
        st.setString(2, u.getNome());
        st.setDouble(3, u.getPesoAtual());
        st.setDouble(4, u.getAltura());
        st.setInt(5, u.getMetaCalorica());
        st.setInt(6, u.getMetaProteina());
        st.setString(7, u.getObjetivo());
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM Usuario WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static HashSet<UsuarioBean> listAll(Connection con) throws SQLException {
        HashSet<UsuarioBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT id, nome, peso_atual, altura, meta_calorica, meta_proteina, objetivo FROM Usuario";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new UsuarioBean(result.getInt(1), result.getString(2), result.getDouble(3),
                    result.getDouble(4), result.getInt(5), result.getInt(6), result.getString(7)));
        }
        st.close();
        return list;
    }
}
