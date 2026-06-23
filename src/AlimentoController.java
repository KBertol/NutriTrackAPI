import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller da entidade Alimento.
 */
public class AlimentoController {

    public void createAlimento(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do novo Alimento: ");
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("nome: ");
        input.nextLine();
        String nome = input.nextLine();
        System.out.print("calorias_100g (kcal): ");
        double calorias = input.nextDouble();
        System.out.print("proteina_100g (g): ");
        double proteina = input.nextDouble();
        System.out.print("carboidrato_100g (g): ");
        double carboidrato = input.nextDouble();
        System.out.print("gordura_100g (g): ");
        double gordura = input.nextDouble();
        System.out.print("categoria_id: ");
        int categoriaId = input.nextInt();

        AlimentoBean a = new AlimentoBean(id, nome, calorias, proteina, carboidrato, gordura, categoriaId);
        AlimentoModel.create(a, con);
        System.out.println("Alimento criado com sucesso!");
    }

    public void removerAlimento(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o id do Alimento a remover: ");
        int id = input.nextInt();
        AlimentoModel.delete(id, con);
        System.out.println("Alimento removido com sucesso (se o id existia)!");
    }

    public void listarAlimentos(Connection con) throws SQLException {
        HashSet<AlimentoBean> all = AlimentoModel.listAll(con);
        Iterator<AlimentoBean> it = all.iterator();
        System.out.println("--- ALIMENTOS ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    /**
     * Consulta com JUNCAO entre Alimento e Categoria.
     */
    public void listarAlimentosComCategoria(Connection con) throws SQLException {
        HashSet<AlimentoBean> all = AlimentoModel.listAllWithCategoria(con);
        Iterator<AlimentoBean> it = all.iterator();
        System.out.println("--- ALIMENTOS JOIN CATEGORIA ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
