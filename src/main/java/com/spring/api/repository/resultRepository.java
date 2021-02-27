package com.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.api.model.result;

@Repository
public interface resultRepository extends JpaRepository<result, Integer> {

}