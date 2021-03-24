/*
 *  PayU Latam - Copyright (c) 2013-2019.
 *  https://www.payulatam.com/co/
 */

package com.newstartup.litepaymentservice.application.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The application starter, the main class that is gonna start the application
 * by configuring all the layers' dependencies and setting all together as a unique piece
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@EnableCaching
@SpringBootApplication
public class Application {

	/**
	 * Main method that starts the application after configure its layers
	 *
	 * @param args the execution arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}


}
