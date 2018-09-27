/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.service;

import java.util.List;
import pe.edu.upeu.evento.model.Asistencia;

/**
 *
 * @author davidmp
 */
public interface AsistenciaServis {
    public List<Asistencia> listarEntidad();
    public Asistencia buscarEntidad(int id);
    public void guardarEntidad(Asistencia asistencia);
    public void eliminarEntidad(int id);
    public void modificarEntidadId(Asistencia asistencia);
    public List<Asistencia> listarPorNombre(String nombre);     
}
