/**
 * Bean da entidade Alimento.
 * O atributo "categoria" e opcional e e preenchido apenas quando o
 * resultado vem de uma consulta com JUNCAO (JOIN) com Categoria.
 */
public class AlimentoBean {
    private int id;
    private String nome;
    private double calorias100g;
    private double proteina100g;
    private double carboidrato100g;
    private double gordura100g;
    private int categoriaId;
    private CategoriaBean categoria;

    public AlimentoBean(int id, String nome, double calorias100g, double proteina100g,
                         double carboidrato100g, double gordura100g, int categoriaId) {
        this.id = id;
        this.nome = nome;
        this.calorias100g = calorias100g;
        this.proteina100g = proteina100g;
        this.carboidrato100g = carboidrato100g;
        this.gordura100g = gordura100g;
        this.categoriaId = categoriaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCalorias100g() {
        return calorias100g;
    }

    public void setCalorias100g(double calorias100g) {
        this.calorias100g = calorias100g;
    }

    public double getProteina100g() {
        return proteina100g;
    }

    public void setProteina100g(double proteina100g) {
        this.proteina100g = proteina100g;
    }

    public double getCarboidrato100g() {
        return carboidrato100g;
    }

    public void setCarboidrato100g(double carboidrato100g) {
        this.carboidrato100g = carboidrato100g;
    }

    public double getGordura100g() {
        return gordura100g;
    }

    public void setGordura100g(double gordura100g) {
        this.gordura100g = gordura100g;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public CategoriaBean getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaBean categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
          .append(" | nome: ").append(nome)
          .append(" | kcal/100g: ").append(calorias100g)
          .append(" | proteina/100g: ").append(proteina100g)
          .append(" | carbo/100g: ").append(carboidrato100g)
          .append(" | gordura/100g: ").append(gordura100g)
          .append(" | categoria_id: ").append(categoriaId);
        if (categoria != null) {
            sb.append(" | categoria: ").append(categoria.getNome());
        }
        return sb.toString();
    }
}
