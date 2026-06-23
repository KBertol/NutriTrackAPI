import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsavel por abrir e encerrar a conexao com o banco de
 * dados PostgreSQL utilizado pela aplicacao NutriTrack.
 *
 * Altere usuario, senha e o nome do banco conforme a configuracao
 * do seu PostgreSQL local.
 */
public class Conexao {
    private Connection con;

    public Conexao() {
        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "KV1234";
        String url = "jdbc:postgresql://localhost:5432/bulking_db";

        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
