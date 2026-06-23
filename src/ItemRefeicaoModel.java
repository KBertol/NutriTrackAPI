import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Model da entidade ItemRefeicao.
 */
public class ItemRefeicaoModel {

    public static void create(ItemRefeicaoBean i, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement(
                "INSERT INTO ItemRefeicao (id, refeicao_id, alimento_id, quantidade_gramas) VALUES (?,?,?,?)");
        st.setInt(1, i.getId());
        st.setInt(2, i.getRefeicaoId());
        st.setInt(3, i.getAlimentoId());
        st.setDouble(4, i.getQuantidadeGramas());
        st.execute();
        st.close();
    }

    public static void delete(int id, Connection con) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM ItemRefeicao WHERE id = ?");
        st.setInt(1, id);
        st.execute();
        st.close();
    }

    public static HashSet<ItemRefeicaoBean> listAll(Connection con) throws SQLException {
        HashSet<ItemRefeicaoBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT id, refeicao_id, alimento_id, quantidade_gramas FROM ItemRefeicao";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new ItemRefeicaoBean(result.getInt(1), result.getInt(2), result.getInt(3), result.getDouble(4)));
        }
        st.close();
        return list;
    }

    /**
     * Consulta com JUNCAO (JOIN) entre ItemRefeicao e Alimento: mostra
     * cada item de refeicao junto com o nome do alimento e as calorias
     * efetivamente consumidas naquele item (calorias_100g * quantidade / 100).
     */
    public static HashSet<ItemRefeicaoBean> listAllWithAlimento(Connection con) throws SQLException {
        HashSet<ItemRefeicaoBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql = "SELECT ir.id, ir.refeicao_id, ir.alimento_id, ir.quantidade_gramas, "
                + "a.id, a.nome, a.calorias_100g, a.proteina_100g, a.carboidrato_100g, a.gordura_100g, a.categoria_id "
                + "FROM ItemRefeicao ir JOIN Alimento a ON ir.alimento_id = a.id";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            ItemRefeicaoBean i = new ItemRefeicaoBean(result.getInt(1), result.getInt(2), result.getInt(3), result.getDouble(4));
            AlimentoBean a = new AlimentoBean(result.getInt(5), result.getString(6), result.getDouble(7),
                    result.getDouble(8), result.getDouble(9), result.getDouble(10), result.getInt(11));
            i.setAlimento(a);
            list.add(i);
        }
        st.close();
        return list;
    }
}
