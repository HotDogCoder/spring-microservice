package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DataEntity;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
}