package me.jmll.utm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 *  3(b) Establece el escaneo de componentes del
 *  paquete me.jmll.utm.web con filtro de inclusión
 *  org.springframework.stereotype.Controller
 * */
@Configuration
@EnableWebMvc
//Escribe tu código aquí {

//} 
public class ServletContextConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Maneja las solicitudes HTTP GET para /resources/** al servir 
	 * eficientemente  recursos estáticos en
	 * el directorio ${webappRoot}/resources 
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		super.addResourceHandlers(registry);
	}

	/**
	 * 3(c) Resuelve vistas seleccionadas al interpretar .jsp por @Controllers 
	 * en el directorio /WEB-INF/views
	 * */
	// Escribe tu código aquí {

	// } 
    public ViewResolver getViewResolver(){
		// Escribe tu código aquí {

		// } 
	}
}