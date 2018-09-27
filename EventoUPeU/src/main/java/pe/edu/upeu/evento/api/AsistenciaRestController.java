/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.evento.model.Asistencia;
import pe.edu.upeu.evento.model.Evento;
import pe.edu.upeu.evento.service.AsistenciaServis;

/**
 *
 * @author davidmp
 */
@RestController
@RequestMapping("/asist")
public class AsistenciaRestController {

    @Autowired
    public AsistenciaServis servis;   
    
    
   
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Asistencia> listarUsuarios(){return servis.listarEntidad(); }
    
    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void modificarEntidadId(@RequestBody Asistencia asistencia) {
        servis.modificarEntidadId(asistencia);
    }

    
    @RequestMapping(value = "remove/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void eliminarEntidadId(@PathVariable String id) {
        System.out.println("Holas "+id);
        int dato=Integer.parseInt(id);
        servis.eliminarEntidad(dato);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Asistencia buscarEntidadId(@PathVariable String id) {
        System.out.println("Holas  DMP------> "+id);        
        int dato=Integer.parseInt(id);
        return servis.buscarEntidad(dato);
    }
    @RequestMapping(value = "/findn/{nombre}", method = RequestMethod.GET)
    public List<Asistencia> buscarEntidadNombre(@PathVariable String nombre) {
        return servis.listarPorNombre(nombre);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void guardarEntidad(@RequestBody Asistencia asistencia) {
   // public void guardarEntidad(@RequestBody HttpServletRequest request) {
        //System.out.println("DMP------>"+usuario.getNombres());
        //System.out.println("Probar: "+request.getParameter("usuario"));
        servis.guardarEntidad(asistencia);
    } 
    
}
