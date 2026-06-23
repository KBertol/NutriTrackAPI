/**
 * Bean da entidade Usuario.
 */
public class UsuarioBean {
    private int id;
    private String nome;
    private double pesoAtual;
    private double altura;
    private int metaCalorica;
    private int metaProteina;
    private String objetivo; // 'bulking', 'cutting', 'manutencao'

    public UsuarioBean(int id, String nome, double pesoAtual, double altura,
                        int metaCalorica, int metaProteina, String objetivo) {
        this.id = id;
        this.nome = nome;
        this.pesoAtual = pesoAtual;
        this.altura = altura;
        this.metaCalorica = metaCalorica;
        this.metaProteina = metaProteina;
        this.objetivo = objetivo;
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

    public double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getMetaCalorica() {
        return metaCalorica;
    }

    public void setMetaCalorica(int metaCalorica) {
        this.metaCalorica = metaCalorica;
    }

    public int getMetaProteina() {
        return metaProteina;
    }

    public void setMetaProteina(int metaProteina) {
        this.metaProteina = metaProteina;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "id: " + id + " | nome: " + nome + " | peso_atual: " + pesoAtual +
               " | altura: " + altura + " | meta_calorica: " + metaCalorica +
               " | meta_proteina: " + metaProteina + " | objetivo: " + objetivo;
    }
}
