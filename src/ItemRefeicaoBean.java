/**
 * Bean da entidade ItemRefeicao.
 * O atributo "alimento" e opcional e e preenchido apenas quando o
 * resultado vem de uma consulta com JUNCAO (JOIN) com Alimento.
 */
public class ItemRefeicaoBean {
    private int id;
    private int refeicaoId;
    private int alimentoId;
    private double quantidadeGramas;
    private AlimentoBean alimento;

    public ItemRefeicaoBean(int id, int refeicaoId, int alimentoId, double quantidadeGramas) {
        this.id = id;
        this.refeicaoId = refeicaoId;
        this.alimentoId = alimentoId;
        this.quantidadeGramas = quantidadeGramas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefeicaoId() {
        return refeicaoId;
    }

    public void setRefeicaoId(int refeicaoId) {
        this.refeicaoId = refeicaoId;
    }

    public int getAlimentoId() {
        return alimentoId;
    }

    public void setAlimentoId(int alimentoId) {
        this.alimentoId = alimentoId;
    }

    public double getQuantidadeGramas() {
        return quantidadeGramas;
    }

    public void setQuantidadeGramas(double quantidadeGramas) {
        this.quantidadeGramas = quantidadeGramas;
    }

    public AlimentoBean getAlimento() {
        return alimento;
    }

    public void setAlimento(AlimentoBean alimento) {
        this.alimento = alimento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
          .append(" | refeicao_id: ").append(refeicaoId)
          .append(" | alimento_id: ").append(alimentoId)
          .append(" | quantidade_gramas: ").append(quantidadeGramas);
        if (alimento != null) {
            sb.append(" | alimento: ").append(alimento.getNome())
              .append(" | kcal_no_item: ").append(alimento.getCalorias100g() * quantidadeGramas / 100.0);
        }
        return sb.toString();
    }
}
