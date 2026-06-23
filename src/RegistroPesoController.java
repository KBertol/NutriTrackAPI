import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Controller da entidade RegistroPeso.
 */
public class RegistroPesoController {

    public void createRegistroPeso(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados do novo Registro de Peso: ");
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("usuario_id: ");
        int usuarioId = input.nextInt();
        System.out.print("data (AAAA-MM-DD): ");
        input.nextLine();
        String dataStr = input.nextLine();
        System.out.print("peso_kg: ");
        double pesoKg = input.nextDouble();

        Date data = Date.valueOf(dataStr);

        RegistroPesoBean r = new RegistroPesoBean(id, usuarioId, data, pesoKg);
        RegistroPesoModel.create(r, con);
        System.out.println("Registro de peso criado com sucesso!");
    }

    public void removerRegistroPeso(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o id do Registro de Peso a remover: ");
        int id = input.nextInt();
        RegistroPesoModel.delete(id, con);
        System.out.println("Registro de peso removido com sucesso (se o id existia)!");
    }

    public void listarRegistrosPeso(Connection con) throws SQLException {
        HashSet<RegistroPesoBean> all = RegistroPesoModel.listAll(con);
        Iterator<RegistroPesoBean> it = all.iterator();
        System.out.println("--- REGISTROS DE PESO ---");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
