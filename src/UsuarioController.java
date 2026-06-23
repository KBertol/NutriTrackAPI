import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller da entidade Usuario: le os dados digitados pelo usuario
 * no console e chama o Model correspondente.
 */
public class UsuarioController {

    public void createUsuario(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do novo Usuario: ");
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("nome: ");
        input.nextLine();
        String nome = input.nextLine();
        System.out.print("peso_atual (kg): ");
        double pesoAtual = input.nextDouble();
        System.out.print("altura (m): ");
        double altura = input.nextDouble();
        System.out.print("meta_calorica (kcal): ");
        int metaCalorica = input.nextInt();
        System.out.print("meta_proteina (g): ");
        int metaProteina = input.nextInt();
        System.out.print("objetivo (bulking/cutting/manutencao): ");
        input.nextLine();
        String objetivo = input.nextLine();

        UsuarioBean u = new UsuarioBean(id, nome, pesoAtual, altura, metaCalorica, metaProteina, objetivo);
        UsuarioModel.create(u, con);
        System.out.println("Usuario criado com sucesso!");
    }

    public void removerUsuario(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o id do Usuario a remover: ");
        int id = input.nextInt();
        UsuarioModel.delete(id, con);
        System.out.println("Usuario removido com sucesso (se o id existia)!");
    }

    public void listarUsuarios(Connection con) throws SQLException {
        HashSet<UsuarioBean> all = UsuarioModel.listAll(con);
        Iterator<UsuarioBean> it = all.iterator();
        System.out.println("--- USUARIOS ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
