package com.example.clinicaOdontologica;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {

		//Esta línea de código se utiliza para inicializar y configurar el sistema de registro.
		//Este archivo de propiedades define cómo se registrarán los mensajes de la aplicación.
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);

	}
}
