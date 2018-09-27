/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.evento.SysDataAccess;
import pe.edu.upeu.evento.model.Persona;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Repository("personaDAO")
public class PersonaDaoImpl extends SysDataAccess<Integer, Persona> implements PersonaDao{
  
    @SuppressWarnings("unchecked")
    @Override
    public List<Persona> listarEntidad(){ return getListAll();}
    @Override
    public Persona buscarEntidad(int id){ return getById(id);}
    @Override
    public void guardarEntidad(Persona persona){ savev(persona);}
    @Override
    public void eliminarEntidad(int id){ delete(id); }
    @Override
    public void modificarEntidadId(Persona persona){ update(persona); }
    
}
