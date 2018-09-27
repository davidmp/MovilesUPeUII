/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.dao;

import java.util.List;
import pe.edu.upeu.evento.model.Persona;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
public interface PersonaDao {
    public List<Persona> listarEntidad();
    public Persona buscarEntidad(int id);
    public void guardarEntidad(Persona persona);
    public void eliminarEntidad(int id);
    public void modificarEntidadId(Persona persona);
    
    
}
