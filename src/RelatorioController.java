import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Controller responsavel pela consulta com SUBCONSULTA + FUNCAO(OES)
 * DE AGREGACAO exigida pelo trabalho.
 *
 * A consulta com JUNCAO entre duas tabelas tambem esta disponivel em
 * AlimentoController.listarAlimentosComCategoria() e em
 * ItemRefeicaoController.listarItensRefeicaoComAlimento().
 */
public class RelatorioController {

    public void exibirProteinaConsumidaVsMeta(Connection con) throws SQLException {
        HashSet<RelatorioProteinaBean> all = RelatorioModel.proteinaConsumidaVsMeta(con);
        Iterator<RelatorioProteinaBean> it = all.iterator();
        System.out.println("--- PROTEINA CONSUMIDA (ultimo dia registrado) x META (subconsulta + SUM/MAX) ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
