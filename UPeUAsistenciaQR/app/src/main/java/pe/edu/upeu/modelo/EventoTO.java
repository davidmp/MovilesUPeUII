package pe.edu.upeu.modelo;

public class EventoTO {

	int idEvento;
	String fecha,
    horainicio,
    horafin,
    nombreevento,
    lugarevento,
    tiempotolerancia,
    estado;
   double longitud;
   double latitud;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        this.nombreevento = nombreevento;
    }

    public String getLugarevento() {
        return lugarevento;
    }

    public void setLugarevento(String lugarevento) {
        this.lugarevento = lugarevento;
    }

    public String getTiempotolerancia() {
        return tiempotolerancia;
    }

    public void setTiempotolerancia(String tiempotolerancia) {
        this.tiempotolerancia = tiempotolerancia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
