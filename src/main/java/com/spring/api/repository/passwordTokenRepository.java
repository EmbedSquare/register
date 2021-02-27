package com.spring.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.api.model.passwordToken;

@Repository
@Transactional
public interface passwordTokenRepository extends JpaRepository<passwordToken, Integer> {

	passwordToken findByUserId(int id);

}
