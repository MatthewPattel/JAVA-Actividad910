package me.jmll.utm;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private HelloService helloService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simplemente selecciona el template home.jsp para
	 * interpretarlo como respuesta
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Crea un Response Body con un servicio en específico.
	 */
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET, params = {"name"})
	public String homeName(Locale locale, Model model, @RequestParam("name") String name) {
		logger.info("Welcome home! {} The client locale is {}.", name, locale);
		
		return helloService.getHello(name);
	}
	
	/* 4(a) Inyectar HelloService en HomeController */
	public void setHelloService(HelloService helloService)
    {
        this.helloService = helloService;
    }
}
