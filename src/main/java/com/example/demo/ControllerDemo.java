package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ControllerDemo {

	@Autowired
    private RestTemplate restTemplate;

	
	private static Logger log = LoggerFactory.getLogger(ControllerDemo.class);
	
	
	@RequestMapping("/trace/exito/")
	@ResponseBody
	public String traceExito()throws Exception {
			
		log.info("llamada demo sleuth");
		String rpta = restTemplate.getForObject("http://localhost:8085/servicio-intermedio/serviciointermedio", String.class);
		String rpta2 = restTemplate.getForObject("http://localhost:8083/servidor-pricipal/trace/exito/", String.class);
		return rpta+"-"+rpta2;
	}
	
	@RequestMapping("/trace/error/")
	@ResponseBody
	public String traceError(){
			
		log.info("llamada demo sleuth");
		return "ok";
		
	}
}
