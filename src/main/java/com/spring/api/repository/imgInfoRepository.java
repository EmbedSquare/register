package com.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.api.model.imgInfo;

@Repository
public interface imgInfoRepository extends JpaRepository<imgInfo, Integer> {

	imgInfo existsByFileName(String fileName);

}