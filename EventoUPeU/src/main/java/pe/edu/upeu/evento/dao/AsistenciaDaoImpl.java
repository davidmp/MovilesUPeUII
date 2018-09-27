/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.evento.SysDataAccess;
import pe.edu.upeu.evento.model.Asistencia;

/**
 *
 * @author davidmp
 */
@Repository("asistenciaDao")
public class AsistenciaDaoImpl extends SysDataAccess<Integer, Asistencia> implements AsistenciaDao{
    @SuppressWarnings("unchecked")
    public List<Asistencia> listarEntidad() { return getListAll();}
    public Asistencia buscarEntidad(int id) { return getById(id);}
    public void guardarEntidad(Asistencia asistencia) {savev(asistencia); }
    public void eliminarEntidad(int id) { delete(id);}
    public void modificarEntidadId(Asistencia asistencia) { update(asistencia); }
    public List<Asistencia> listarPorNombre(String nombre) {
    return (List<Asistencia>)sessionFactory.getCurrentSession()
            .createQuery("select a from Asistencia a where a.idUsuario.nombres like ?")
            .setString(0, "%"+nombre+"%")
            .list();
    }     
}
