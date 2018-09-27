/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Entity
@Table(name = "mensajes")
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")})
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMensajes")
    private Integer idMensajes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numeroenvio")
    private String numeroenvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numerorecepcion")
    private String numerorecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "mensajeentregado")
    private String mensajeentregado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipomensaje")
    private String tipomensaje;
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Mensajes() {
    }

    public Mensajes(Integer idMensajes) {
        this.idMensajes = idMensajes;
    }

    public Mensajes(Integer idMensajes, String numeroenvio, String numerorecepcion, String mensajeentregado, String tipomensaje) {
        this.idMensajes = idMensajes;
        this.numeroenvio = numeroenvio;
        this.numerorecepcion = numerorecepcion;
        this.mensajeentregado = mensajeentregado;
        this.tipomensaje = tipomensaje;
    }

    public Integer getIdMensajes() {
        return idMensajes;
    }

    public void setIdMensajes(Integer idMensajes) {
        this.idMensajes = idMensajes;
    }

    public String getNumeroenvio() {
        return numeroenvio;
    }

    public void setNumeroenvio(String numeroenvio) {
        this.numeroenvio = numeroenvio;
    }

    public String getNumerorecepcion() {
        return numerorecepcion;
    }

    public void setNumerorecepcion(String numerorecepcion) {
        this.numerorecepcion = numerorecepcion;
    }

    public String getMensajeentregado() {
        return mensajeentregado;
    }

    public void setMensajeentregado(String mensajeentregado) {
        this.mensajeentregado = mensajeentregado;
    }

    public String getTipomensaje() {
        return tipomensaje;
    }

    public void setTipomensaje(String tipomensaje) {
        this.tipomensaje = tipomensaje;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensajes != null ? idMensajes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.idMensajes == null && other.idMensajes != null) || (this.idMensajes != null && !this.idMensajes.equals(other.idMensajes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upeu.evento.model.Mensajes[ idMensajes=" + idMensajes + " ]";
    }
    
}
