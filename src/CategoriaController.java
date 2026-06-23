import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller da entidade Categoria.
 */
public class CategoriaController {

    public void createCategoria(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados da nova Categoria: ");
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("nome: ");
        input.nextLine();
        String nome = input.nextLine();
        System.out.print("descricao: ");
        String descricao = input.nextLine();

        CategoriaBean c = new CategoriaBean(id, nome, descricao);
        CategoriaModel.create(c, con);
        System.out.println("Categoria criada com sucesso!");
    }

    public void removerCategoria(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o id da Categoria a remover: ");
        int id = input.nextInt();
        CategoriaModel.delete(id, con);
        System.out.println("Categoria removida com sucesso (se o id existia)!");
    }

    public void listarCategorias(Connection con) throws SQLException {
        HashSet<CategoriaBean> all = CategoriaModel.listAll(con);
        Iterator<CategoriaBean> it = all.iterator();
        System.out.println("--- CATEGORIAS ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
