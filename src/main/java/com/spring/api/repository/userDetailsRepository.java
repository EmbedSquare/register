package com.spring.api.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.api.model.userInfo;

@Repository
public interface userDetailsRepository extends JpaRepository<userInfo, Integer> {

	public userInfo findByUserNameAndEnabled(String userName, short enabled);

	public List<userInfo> findAllByEnabled(short enabled);

}
