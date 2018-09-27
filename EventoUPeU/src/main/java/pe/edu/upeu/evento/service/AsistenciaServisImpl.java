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
import pe.edu.upeu.evento.dao.AsistenciaDao;
import pe.edu.upeu.evento.model.Asistencia;

/**
 *
 * @author davidmp
 */
@Service("asistenciaServis")
@Transactional
public class AsistenciaServisImpl implements AsistenciaServis{
    
    @Autowired
    public AsistenciaDao dao;

    @Override
    public List<Asistencia> listarEntidad() {return dao.listarEntidad();}

    @Override
    public Asistencia buscarEntidad(int id) {return dao.buscarEntidad(id);}

    @Override
    public void guardarEntidad(Asistencia asistencia) {dao.guardarEntidad(asistencia);}

    @Override
    public void eliminarEntidad(int id) {dao.eliminarEntidad(id);}

    @Override
    public void modificarEntidadId(Asistencia asistencia) {dao.modificarEntidadId(asistencia);}

    @Override
    public List<Asistencia> listarPorNombre(String nombre) {return dao.listarPorNombre(nombre);}      
}
