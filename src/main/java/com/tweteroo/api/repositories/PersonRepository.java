package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Person;

public interface PersonRepository extends JpaRepository <Person, Long>{
    
}
