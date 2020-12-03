package com.imset.foody.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	@RequestMapping("/users")
	public String getUsers() {
		return "test";
	}
}
