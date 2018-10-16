package pe.edu.upeu.modelo;

public class AsistenciaTO {

	int idAsistencia;
	Object idPersona, idUsuario, idEvento;
    String codigo, nombres, companhia, fechahora, ofline;

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Object getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Object idPersona) {
        this.idPersona = idPersona;
    }

    public Object getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Object idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Object getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Object idEvento) {
        this.idEvento = idEvento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getOfline() {
        return ofline;
    }

    public void setOfline(String ofline) {
        this.ofline = ofline;
    }
}
