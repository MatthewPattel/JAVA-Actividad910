package me.jmll.utm.web;

import org.springframework.stereotype.Service;

/** 1(a) Define que Spring cree una instancia de HelloServiceImpl */
@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public String getHello(String name) {
		return String.format("Welcome %s!", name).toString();
	}

}



