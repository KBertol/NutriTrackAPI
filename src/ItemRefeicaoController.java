import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller da entidade ItemRefeicao.
 */
public class ItemRefeicaoController {

    public void createItemRefeicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do novo Item de Refeicao: ");
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("refeicao_id: ");
        int refeicaoId = input.nextInt();
        System.out.print("alimento_id: ");
        int alimentoId = input.nextInt();
        System.out.print("quantidade_gramas: ");
        double quantidade = input.nextDouble();

        ItemRefeicaoBean i = new ItemRefeicaoBean(id, refeicaoId, alimentoId, quantidade);
        ItemRefeicaoModel.create(i, con);
        System.out.println("Item de refeicao criado com sucesso!");
    }

    public void removerItemRefeicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o id do Item de Refeicao a remover: ");
        int id = input.nextInt();
        ItemRefeicaoModel.delete(id, con);
        System.out.println("Item de refeicao removido com sucesso (se o id existia)!");
    }

    public void listarItensRefeicao(Connection con) throws SQLException {
        HashSet<ItemRefeicaoBean> all = ItemRefeicaoModel.listAll(con);
        Iterator<ItemRefeicaoBean> it = all.iterator();
        System.out.println("--- ITENS DE REFEICAO ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    /**
     * Consulta com JUNCAO entre ItemRefeicao e Alimento.
     */
    public void listarItensRefeicaoComAlimento(Connection con) throws SQLException {
        HashSet<ItemRefeicaoBean> all = ItemRefeicaoModel.listAllWithAlimento(con);
        Iterator<ItemRefeicaoBean> it = all.iterator();
        System.out.println("--- ITENS DE REFEICAO JOIN ALIMENTO ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
