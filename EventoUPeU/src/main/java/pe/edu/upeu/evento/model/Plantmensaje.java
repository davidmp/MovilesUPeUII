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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "plantmensaje")
@NamedQueries({
    @NamedQuery(name = "Plantmensaje.findAll", query = "SELECT p FROM Plantmensaje p")})
public class Plantmensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlantmensaje")
    private Integer idPlantmensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipomensaje")
    private String tipomensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "mensajeprevio")
    private String mensajeprevio;

    public Plantmensaje() {
    }

    public Plantmensaje(Integer idPlantmensaje) {
        this.idPlantmensaje = idPlantmensaje;
    }

    public Plantmensaje(Integer idPlantmensaje, String tipomensaje, String mensajeprevio) {
        this.idPlantmensaje = idPlantmensaje;
        this.tipomensaje = tipomensaje;
        this.mensajeprevio = mensajeprevio;
    }

    public Integer getIdPlantmensaje() {
        return idPlantmensaje;
    }

    public void setIdPlantmensaje(Integer idPlantmensaje) {
        this.idPlantmensaje = idPlantmensaje;
    }

    public String getTipomensaje() {
        return tipomensaje;
    }

    public void setTipomensaje(String tipomensaje) {
        this.tipomensaje = tipomensaje;
    }

    public String getMensajeprevio() {
        return mensajeprevio;
    }

    public void setMensajeprevio(String mensajeprevio) {
        this.mensajeprevio = mensajeprevio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantmensaje != null ? idPlantmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantmensaje)) {
            return false;
        }
        Plantmensaje other = (Plantmensaje) object;
        if ((this.idPlantmensaje == null && other.idPlantmensaje != null) || (this.idPlantmensaje != null && !this.idPlantmensaje.equals(other.idPlantmensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upeu.evento.model.Plantmensaje[ idPlantmensaje=" + idPlantmensaje + " ]";
    }
    
}
