import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.HashSet;

/**
 * Model da entidade Refeicao.
 */
public class RefeicaoModel {

    public static void create(RefeicaoBean r, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO Refeicao (id, usuario_id, nome, data, hora) VALUES (?,?,?,?,?)");
        st.setInt(1, r.getId());
        st.setInt(2, r.getUsuarioId());
        st.setString(3, r.getNome());
        st.setDate(4, r.getData());
        st.setTime(5, r.getHora());
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM Refeicao WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static HashSet<RefeicaoBean> listAll(Connection con) throws SQLException {
        HashSet<RefeicaoBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT id, usuario_id, nome, data, hora FROM Refeicao";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new RefeicaoBean(result.getInt(1), result.getInt(2), result.getString(3),
                    result.getDate(4), result.getTime(5)));
        }
        st.close();
        return list;
    }
}
