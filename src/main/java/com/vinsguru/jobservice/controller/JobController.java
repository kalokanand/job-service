package com.vinsguru.jobservice.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinsguru.jobservice.dto.JobDto;
import com.vinsguru.jobservice.service.JobService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private JobService service;
	
	@GetMapping("all")
	public Flux<JobDto> allJobs() {
		return service.allJobs();
	}
	
	@GetMapping("search")
	public Flux<JobDto> jobsBySkillsIn(Set<String> skills) {
		return service.jobsBySkillsIn(skills);
	}
	
	@PostMapping
	public Mono<JobDto> save(@RequestBody Mono<JobDto> mono){
		return service.save(mono);
	}


}
