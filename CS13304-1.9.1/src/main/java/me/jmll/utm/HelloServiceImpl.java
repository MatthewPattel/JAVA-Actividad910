package me.jmll.utm;

/* 3(a) Define que Spring cree una instancia de HelloServiceImpl */
@Component
@Qualifier("bean")


public class HelloServiceImpl implements HelloService {

	@Override
	public String getHello(String name) {
		return String.format("Welcome %s!", name).toString();
	}

}

