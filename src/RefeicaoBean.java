import java.sql.Date;
import java.sql.Time;

/**
 * Bean da entidade Refeicao.
 */
public class RefeicaoBean {
    private int id;
    private int usuarioId;
    private String nome; // 'Cafe da manha', 'Almoco', 'Jantar', etc.
    private Date data;
    private Time hora;

    public RefeicaoBean(int id, int usuarioId, String nome, Date data, Time hora) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "id: " + id + " | usuario_id: " + usuarioId + " | nome: " + nome +
               " | data: " + data + " | hora: " + hora;
    }
}
