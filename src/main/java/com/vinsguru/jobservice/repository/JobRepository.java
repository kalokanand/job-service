package com.vinsguru.jobservice.repository;

import java.util.Set;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.vinsguru.jobservice.entity.Job;

import reactor.core.publisher.Flux;

public interface JobRepository extends ReactiveCrudRepository<Job, String>{
	
	Flux<Job> findBySkillsIn(Set<String> skills);

}
