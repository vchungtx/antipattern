package com.example.chattyio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chattyio.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
