import java.sql.Date;

/**
 * Bean da entidade RegistroPeso.
 */
public class RegistroPesoBean {
    private int id;
    private int usuarioId;
    private Date data;
    private double pesoKg;

    public RegistroPesoBean(int id, int usuarioId, Date data, double pesoKg) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.data = data;
        this.pesoKg = pesoKg;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    @Override
    public String toString() {
        return "id: " + id + " | usuario_id: " + usuarioId + " | data: " + data + " | peso_kg: " + pesoKg;
    }
}
