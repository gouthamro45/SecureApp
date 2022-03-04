package com.example.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.example.security.models.Cakes;

@RepositoryRestResource(collectionResourceRel = "Admin",path="Admin")
public interface CakesRepo extends JpaRepository<Cakes, Integer> {
	

}
