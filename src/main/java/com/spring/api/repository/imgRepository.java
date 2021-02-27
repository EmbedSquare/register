package com.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.api.model.imgFile;

@Repository
public interface imgRepository extends JpaRepository<imgFile, Integer> {

	imgFile findById(String imgId);

}