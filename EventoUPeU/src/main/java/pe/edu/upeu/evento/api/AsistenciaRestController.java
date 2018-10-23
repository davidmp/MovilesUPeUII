/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.api;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.evento.model.Asistencia;
import pe.edu.upeu.evento.model.Evento;
import pe.edu.upeu.evento.service.AsistenciaServis;
import pe.edu.upeu.evento.service.EventoServis;
import pe.edu.upeu.evento.service.PersonaServis;
import pe.edu.upeu.evento.service.UsuarioServis;

/**
 *
 * @author davidmp
 */
@RestController
@RequestMapping("/asist")
public class AsistenciaRestController {

    @Autowired
    public AsistenciaServis servis;   
    @Autowired
    public EventoServis servisEv;   
    @Autowired
    public UsuarioServis servisUsu;   
    @Autowired
    public PersonaServis serviPer;   
    
    private final static Logger LOGGER = Logger.getLogger("pe.edu.upeu.evento.api.AsistenciaRestController");
   
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

    @RequestMapping(value = "/add/{idEvento}/{idUsuario}/{idPersona}", method = {RequestMethod.GET, RequestMethod.POST})
    public void guardarEntidad(@RequestBody Asistencia asistencia, @PathVariable String idEvento, @PathVariable String idUsuario , @PathVariable String idPersona) {
   // public void guardarEntidad(@RequestBody HttpServletRequest request) {
        //System.out.println("DMP------>"+usuario.getNombres());
        //System.out.println("Probar: "+request.getParameter("usuario"));
        asistencia.setIdEvento(servisEv.buscarEntidad(Integer.parseInt(idEvento)));
        asistencia.setIdUsuario(servisUsu.buscarUsuario(Integer.parseInt(idUsuario)));
        asistencia.setIdPersona(serviPer.buscarEntidad(Integer.parseInt(idPersona)));
        asistencia.setFechahora("2018-10-23");
        asistencia.setOfline("no");
        LOGGER.log(Level.INFO, "Proceso Fecha : "+asistencia.getFechahora());
        LOGGER.log(Level.INFO, "Proceso Modo : "+asistencia.getOfline());

        LOGGER.log(Level.INFO, "Proceso exitoso : "+idEvento);
        LOGGER.log(Level.INFO, "Codigo : "+asistencia.getCodigo());
        LOGGER.log(Level.INFO, "Nombre Evento : "+servisEv.buscarEntidad(Integer.parseInt(idEvento)).getNombreevento());
        servis.guardarEntidad(asistencia);
    } 
    
}
