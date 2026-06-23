import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * NutriTrack - Aplicativo de Rastreamento Nutricional e Planejamento
 * Dietetico (foco em Bulking/Macros).
 *
 * Classe principal: monta o menu do sistema e direciona para os
 * Controllers correspondentes. Toda a comunicacao com o banco de
 * dados e feita via JDBC puro (sem frameworks de ORM/abstracao).
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op;
        do {
            op = menuPrincipal();
            try {
                switch (op) {
                    case 1:
                        menuInserir(con);
                        break;
                    case 2:
                        menuRemover(con);
                        break;
                    case 3:
                        listarTodasAsTabelas(con);
                        break;
                    case 4:
                        menuJuncao(con);
                        break;
                    case 5:
                        new RelatorioController().exibirProteinaConsumidaVsMeta(con);
                        break;
                    default:
                        break;
                }
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        } while (op != 0);

        con.close();
        System.out.println("Ate logo!");
    }

    // ---------------------------------------------------------------
    // MENU PRINCIPAL
    // ---------------------------------------------------------------
    private static int menuPrincipal() {
        System.out.println("");
        System.out.println("==================== NUTRITRACK ====================");
        System.out.println("1 - Inserir dados (em qualquer tabela)");
        System.out.println("2 - Remover dados (em qualquer tabela)");
        System.out.println("3 - Listar todas as tuplas de todas as tabelas");
        System.out.println("4 - Consulta com JUNCAO entre duas tabelas");
        System.out.println("5 - Consulta com SUBCONSULTA + funcao de AGREGACAO");
        System.out.println("0 - Sair");
        System.out.print("Sua opcao: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    // ---------------------------------------------------------------
    // SUBMENU: INSERIR
    // ---------------------------------------------------------------
    private static void menuInserir(Connection con) throws SQLException {
        System.out.println("");
        System.out.println("----- INSERIR -----");
        System.out.println("1 - Usuario");
        System.out.println("2 - Categoria");
        System.out.println("3 - Alimento");
        System.out.println("4 - Refeicao");
        System.out.println("5 - ItemRefeicao");
        System.out.println("6 - RegistroPeso");
        System.out.println("0 - Voltar");
        System.out.print("Sua opcao: ");
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1:
                new UsuarioController().createUsuario(con);
                break;
            case 2:
                new CategoriaController().createCategoria(con);
                break;
            case 3:
                new AlimentoController().createAlimento(con);
                break;
            case 4:
                new RefeicaoController().createRefeicao(con);
                break;
            case 5:
                new ItemRefeicaoController().createItemRefeicao(con);
                break;
            case 6:
                new RegistroPesoController().createRegistroPeso(con);
                break;
            default:
                break;
        }
    }

    // ---------------------------------------------------------------
    // SUBMENU: REMOVER
    // ---------------------------------------------------------------
    private static void menuRemover(Connection con) throws SQLException {
        System.out.println("");
        System.out.println("----- REMOVER -----");
        System.out.println("1 - Usuario");
        System.out.println("2 - Categoria");
        System.out.println("3 - Alimento");
        System.out.println("4 - Refeicao");
        System.out.println("5 - ItemRefeicao");
        System.out.println("6 - RegistroPeso");
        System.out.println("0 - Voltar");
        System.out.print("Sua opcao: ");
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1:
                new UsuarioController().removerUsuario(con);
                break;
            case 2:
                new CategoriaController().removerCategoria(con);
                break;
            case 3:
                new AlimentoController().removerAlimento(con);
                break;
            case 4:
                new RefeicaoController().removerRefeicao(con);
                break;
            case 5:
                new ItemRefeicaoController().removerItemRefeicao(con);
                break;
            case 6:
                new RegistroPesoController().removerRegistroPeso(con);
                break;
            default:
                break;
        }
    }

    // ---------------------------------------------------------------
    // LISTAR TODAS AS TUPLAS DE TODAS AS TABELAS
    // ---------------------------------------------------------------
    private static void listarTodasAsTabelas(Connection con) throws SQLException {
        new UsuarioController().listarUsuarios(con);
        new CategoriaController().listarCategorias(con);
        new AlimentoController().listarAlimentos(con);
        new RefeicaoController().listarRefeicoes(con);
        new ItemRefeicaoController().listarItensRefeicao(con);
        new RegistroPesoController().listarRegistrosPeso(con);
    }

    // ---------------------------------------------------------------
    // SUBMENU: CONSULTAS COM JUNCAO (escolha entre dois exemplos)
    // ---------------------------------------------------------------
    private static void menuJuncao(Connection con) throws SQLException {
        System.out.println("");
        System.out.println("----- CONSULTA COM JUNCAO -----");
        System.out.println("1 - Alimento JOIN Categoria");
        System.out.println("2 - ItemRefeicao JOIN Alimento");
        System.out.println("0 - Voltar");
        System.out.print("Sua opcao: ");
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1:
                new AlimentoController().listarAlimentosComCategoria(con);
                break;
            case 2:
                new ItemRefeicaoController().listarItensRefeicaoComAlimento(con);
                break;
            default:
                break;
        }
    }
}
