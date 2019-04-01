package me.jmll.utm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;


/**
 *  3(a) Establece el escaneo de componentes del
 *  paquete me.jmll.utm.web con filtro de exclusión
 *  org.springframework.stereotype.Controller
 * */
@Configuration
@ComponentScan(basePackages = "me.jmll.utm.web", excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootContextConfig {

}


