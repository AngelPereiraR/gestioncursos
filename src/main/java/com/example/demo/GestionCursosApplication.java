package com.example.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GestionCursosApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GestionCursosApplication.class, args);
	}
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException{
        super.onStartup(servletContext);
    }

}
