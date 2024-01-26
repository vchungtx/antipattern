package com.example.chattyio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chattyio.entity.SalesOrderDetail;

public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, Long>{

}
