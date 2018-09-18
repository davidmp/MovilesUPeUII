package pe.edu.upeu.modelo;

public class PersonaTO {
    int idPersona;
    String nombres;
    String apellidos;
    String dnicodigo;
    String email;
    String numerocelular;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDnicodigo() {
        return dnicodigo;
    }

    public void setDnicodigo(String dnicodigo) {
        this.dnicodigo = dnicodigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }
}
