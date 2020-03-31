package com.exercise.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {

		System.setProperty("sun.net.spi.nameservice.nameservers", "223.5.5.5");

		try {
			System.out.println(InetAddress.getByName("qudao.test.ximalaya.com").getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		SpringApplication.run(ReactiveApplication.class, args);
	}

}
