package com.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.api.model.imgDB;

@Repository
public interface imgFileRepository extends JpaRepository<imgDB, Integer> {

	imgDB findById(String imgId);

}
