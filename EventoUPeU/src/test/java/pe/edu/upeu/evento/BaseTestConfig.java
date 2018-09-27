/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.evento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author davidmp
 */

@Configuration
@ComponentScan("pe.edu.upeu")
@EnableWebMvc
public class BaseTestConfig {
	@Bean
	public ViewResolver setupViewResolver() {

                
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();		
		viewResolver.setPrefix("/WEB-INF/upeu/");
		viewResolver.setSuffix(".jsp");  
                viewResolver.setViewClass(JstlView.class);
                
                return viewResolver;
	}    
}
