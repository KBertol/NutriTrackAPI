/**
 * Bean auxiliar utilizado apenas para exibir o resultado da consulta
 * que envolve subconsulta + funcao de agregacao (nao corresponde a
 * uma tabela do banco).
 */
public class RelatorioProteinaBean {
    private String nomeUsuario;
    private java.sql.Date data;
    private double totalProteinaConsumida;
    private int metaProteina;

    public RelatorioProteinaBean(String nomeUsuario, java.sql.Date data,
                                  double totalProteinaConsumida, int metaProteina) {
        this.nomeUsuario = nomeUsuario;
        this.data = data;
        this.totalProteinaConsumida = totalProteinaConsumida;
        this.metaProteina = metaProteina;
    }

    @Override
    public String toString() {
        return "usuario: " + nomeUsuario + " | ultima_data_registrada: " + data +
               " | proteina_consumida(g): " + String.format("%.2f", totalProteinaConsumida) +
               " | meta_proteina(g): " + metaProteina +
               " | bateu_a_meta: " + (totalProteinaConsumida >= metaProteina ? "SIM" : "NAO");
    }
}
