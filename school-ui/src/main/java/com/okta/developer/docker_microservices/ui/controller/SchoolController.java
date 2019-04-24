package com.okta.developer.docker_microservices.ui.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.okta.developer.docker_microservices.ui.dto.TeachingClassDto;

@Controller
@RequestMapping("/")
public class SchoolController {

// VERSION WITHOUT DISCOVERY ENABLED
//
//    private final RestTemplate restTemplate;
//    private final String serviceHost;
//
//    public SchoolController(RestTemplate restTemplate, @Value("${service.host}") String serviceHost) {
//        this.restTemplate = restTemplate;
//        this.serviceHost = serviceHost;
//    }
//
//    @RequestMapping("")
//    public ModelAndView index() {
//        return new ModelAndView("index");
//    }
//
//    @GetMapping("/classes")
//    public ResponseEntity<List<TeachingClassDto>> listClasses(){
//
//        return restTemplate
//                .exchange("http://"+ serviceHost +"/class", HttpMethod.GET, null,
//                        new ParameterizedTypeReference<List<TeachingClassDto>>() {});
//    }
	
	private final RestTemplate restTemplate;

	public SchoolController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@GetMapping("/classes")
	@PreAuthorize("hasAuthority('SCOPE_profile')") //Scope PROFILE = Authenticated users only
	public ResponseEntity<List<TeachingClassDto>> listClasses() {
		return restTemplate.exchange("http://school-service/classes", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TeachingClassDto>>() {
				});
	}
	
	
}
