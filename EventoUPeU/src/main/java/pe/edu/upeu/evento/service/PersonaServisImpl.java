/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.evento.dao.PersonaDao;
import pe.edu.upeu.evento.model.Persona;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Service("PersonaServis")
@Transactional
public class PersonaServisImpl implements PersonaServis{
    
    @Autowired
    PersonaDao dao;
    
    @Override
    public List<Persona> listarEntidad(){return dao.listarEntidad();}
    @Override
    public Persona buscarEntidad(int id){return dao.buscarEntidad(id);}
    @Override
    public void guardarEntidad(Persona persona){ dao.guardarEntidad(persona); }
    @Override
    public void eliminarEntidad(int id){ dao.eliminarEntidad(id); }
    @Override
    public void modificarEntidadId(Persona persona){ dao.modificarEntidadId(persona);}  
}
