package com.spring.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.model.result;
import com.spring.api.repository.resultRepository;

@Service
public class resultServiceImpl implements resultService {

	@Autowired
	private resultRepository dao;

	@Override
	public List<result> getResult() {

		return dao.findAll();
	}

	@Override
	public Optional<result> getResult(int reqId) {

		return dao.findById(reqId);
	}

	@Override
	public result addResult(int voltage, int current, int speed) {

		return dao.save(new result(voltage, current, speed));
	}

	@Override
	public result updateResult(result result) {

		return dao.save(result);
	}

	@Override
	public result deleteResult(int reqId) {

		dao.deleteById(reqId);

		return null;
	}

	/*
	 * @Override public value postValues(int voltage) {
	 * 
	 * return dao.save(voltage);
	 * 
	 * }
	 */

}
