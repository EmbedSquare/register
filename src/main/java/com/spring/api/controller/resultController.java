package com.spring.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.api.model.result;
import com.spring.api.service.resultService;

@RestController
public class resultController {

	@Autowired
	private resultService service;

	@GetMapping("/getResult") /* Get all Result */
	public List<result> getResult() {

		return this.service.getResult();
	}

	@PostMapping("/addResult") /* Add Result */
	public result addResult(@RequestParam int voltage, int current, int speed) {

		return this.service.addResult(voltage, current, speed);
	}

	@GetMapping("/getResult/{reqId}") /* Get result by ID */
	public Optional<result> getResult(@PathVariable int reqId) {

		return this.service.getResult(reqId);
	}

	@PutMapping("/updateResult") /* Update Result */
	public result updateResult(@RequestBody result result) {

		return this.service.updateResult(result);
	}

	@DeleteMapping("/deleteResult/{reqId}") /* Delete Result */
	public result deleteResult(@PathVariable int reqId) {

		return this.service.deleteResult(reqId);
	}

	/*
	 * @PostMapping("values") public value postValues(@RequestBody value value) {
	 * 
	 * return this.service.postValues(value); }
	 */

}
