package com.bkap.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountAPI {
	@GetMapping("")
	public ResponseEntity<String> testSpringBoot() {
		return ResponseEntity.ok("Success");
	}
}
