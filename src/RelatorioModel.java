import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * Model que concentra as consultas mais elaboradas exigidas pelo
 * trabalho: uma consulta com JUNCAO entre duas tabelas e uma consulta
 * com SUBCONSULTA + FUNCAO(OES) DE AGREGACAO.
 *
 * As consultas de JUNCAO entre Alimento/Categoria e entre
 * ItemRefeicao/Alimento ja estao em AlimentoModel.listAllWithCategoria()
 * e ItemRefeicaoModel.listAllWithAlimento(). Aqui fica a consulta de
 * subconsulta + agregacao, que envolve as tabelas Usuario, Refeicao,
 * ItemRefeicao e Alimento.
 */
public class RelatorioModel {

    /**
     * Para cada usuario, calcula o total de proteina consumida na sua
     * refeicao mais recente (subconsulta com MAX) e compara com a meta
     * de proteina cadastrada (funcao de agregacao SUM na consulta
     * externa, agrupada por usuario).
     */
    public static HashSet<RelatorioProteinaBean> proteinaConsumidaVsMeta(Connection con) throws SQLException {
        HashSet<RelatorioProteinaBean> list = new HashSet<>();
        Statement st = con.createStatement();
        String sql =
                "SELECT u.nome, r.data, "
              + "       COALESCE(SUM(a.proteina_100g * ir.quantidade_gramas / 100.0), 0) AS total_proteina, "
              + "       u.meta_proteina "
              + "FROM Usuario u "
              + "JOIN Refeicao r ON r.usuario_id = u.id "
              + "JOIN ItemRefeicao ir ON ir.refeicao_id = r.id "
              + "JOIN Alimento a ON a.id = ir.alimento_id "
              + "WHERE r.data = (SELECT MAX(r2.data) FROM Refeicao r2 WHERE r2.usuario_id = u.id) "
              + "GROUP BY u.nome, r.data, u.meta_proteina "
              + "ORDER BY u.nome";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new RelatorioProteinaBean(result.getString(1), result.getDate(2),
                    result.getDouble(3), result.getInt(4)));
        }
        st.close();
        return list;
    }
}
