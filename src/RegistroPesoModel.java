import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Model da entidade RegistroPeso.
 */
public class RegistroPesoModel {

    public static void create(RegistroPesoBean r, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO RegistroPeso (id, usuario_id, data, peso_kg) VALUES (?,?,?,?)");
        st.setInt(1, r.getId());
        st.setInt(2, r.getUsuarioId());
        st.setDate(3, r.getData());
        st.setDouble(4, r.getPesoKg());
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM RegistroPeso WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static HashSet<RegistroPesoBean> listAll(Connection con) throws SQLException {
        HashSet<RegistroPesoBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT id, usuario_id, data, peso_kg FROM RegistroPeso";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new RegistroPesoBean(result.getInt(1), result.getInt(2), result.getDate(3), result.getDouble(4)));
        }
        st.close();
        return list;
    }
}
