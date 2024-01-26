package com.example.chattyio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chattyio.entity.SalesOrderHeader;

public interface SalesOrderHeaderRepository extends JpaRepository<SalesOrderHeader, Long>{

}
