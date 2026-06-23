import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller da entidade Refeicao.
 */
public class RefeicaoController {

    public void createRefeicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados da nova Refeicao: ");
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("usuario_id: ");
        int usuarioId = input.nextInt();
        System.out.print("nome (ex: Cafe da manha, Almoco, Jantar): ");
        input.nextLine();
        String nome = input.nextLine();
        System.out.print("data (AAAA-MM-DD): ");
        String dataStr = input.nextLine();
        System.out.print("hora (HH:MM:SS): ");
        String horaStr = input.nextLine();

        Date data = Date.valueOf(dataStr);
        Time hora = Time.valueOf(horaStr);

        RefeicaoBean r = new RefeicaoBean(id, usuarioId, nome, data, hora);
        RefeicaoModel.create(r, con);
        System.out.println("Refeicao criada com sucesso!");
    }

    public void removerRefeicao(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o id da Refeicao a remover: ");
        int id = input.nextInt();
        RefeicaoModel.delete(id, con);
        System.out.println("Refeicao removida com sucesso (se o id existia)!");
    }

    public void listarRefeicoes(Connection con) throws SQLException {
        HashSet<RefeicaoBean> all = RefeicaoModel.listAll(con);
        Iterator<RefeicaoBean> it = all.iterator();
        System.out.println("--- REFEICOES ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
