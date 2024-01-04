package com.vinsguru.jobservice.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinsguru.jobservice.dto.JobDto;
import com.vinsguru.jobservice.repository.JobRepository;
import com.vinsguru.jobservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class JobService {

	@Autowired
	private JobRepository repository;

	public Flux<JobDto> allJobs() {
		return repository.findAll().map(EntityDtoUtil::toDto);
	}
	
	public Flux<JobDto> jobsBySkillsIn(Set<String> skills) {
		return repository.findBySkillsIn(skills).map(EntityDtoUtil::toDto);
	}
	
	public Mono<JobDto> save(Mono<JobDto> mono){
		return mono.map(EntityDtoUtil::toEntity)
				.flatMap(this.repository::save)
				.map(EntityDtoUtil::toDto);
	}


}
