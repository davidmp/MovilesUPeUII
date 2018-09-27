/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.upeu.evento.model.Persona;
import pe.edu.upeu.evento.service.PersonaServis;

/**
 *
 * @author LAB_SOFTWARE-DTI
 */
@Controller
@RequestMapping("/")
public class PersonaController {
        @Autowired
        PersonaServis service;	
        
        @Autowired
        MessageSource messageSource;     
        
	@RequestMapping(value = {"qr"}, method = RequestMethod.GET)
	public ModelAndView listPersona(ModelMap model) {
            List<Persona> lista=service.listarEntidad();
            Map<String, Object> modelo=new HashMap<String, Object> ();
            modelo.put("ListaPersona", lista);
            modelo.put("saludo", "Hola amigos");            
            System.out.println("Holassssssssss");
            return  new ModelAndView("index",modelo);
	}    
}
