package me.jmll.utm.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class InitializeApp implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext container) throws ServletException
    {
    	
        container.getServletRegistration("default").addMapping("/resource/*");
        /**
         * Crea e inicializa Spring Root Context
         * */
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfig.class);
        /**
         *  Administra el ciclo de vida del Root Application Context
         * */
        container.addListener(new ContextLoaderListener(rootContext));
        /**
         * Crea e inicializa Spring Servlet Context
         * */
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(ServletContextConfig.class);
        /**
         * Inicializando Servlet Dispatcher
         * */
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "springDispatcher", new DispatcherServlet(servletContext)
        );
        
        
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
