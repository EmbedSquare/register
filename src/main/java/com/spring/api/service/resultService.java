package com.spring.api.service;

import java.util.List;
import java.util.Optional;

import com.spring.api.model.result;

public interface resultService {

	public List<result> getResult();

	public Optional<result> getResult(int reqId);

	/* public value postValues(value value); */

	public result addResult(int voltage, int current, int speed);

	public result updateResult(result result);

	public result deleteResult(int reqId);

}
