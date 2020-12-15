package com.imset.foody.controller;

import java.util.NoSuchElementException;

import com.imset.foody.exception.UserNotFoundException;
import com.imset.foody.model.User;
import com.imset.foody.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping()
	public @ResponseBody  User getUserById(@RequestParam(name="id") Integer id) {
		try {
			User user = userRepository.findById(id).get();
			return user;
			
		}catch (NoSuchElementException e) {
			throw new UserNotFoundException();
		}
	}

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestBody User user) {
		// user.setPassword();
		userRepository.save(user);
		return "Saved";
	}

	@PutMapping(path = "/update")
	public String updateUser(@RequestBody User user, @RequestParam(name = "id") Integer id) {

		try {

			User foundUser = userRepository.findById(id).get();
			System.out.print(foundUser.toString());
			System.out.print(user.toString());
			// user found by his id

			// checking the request body
			// if he got
			if (user.getEmail() != null && user.getEmail().isEmpty() == false) {
				foundUser.setEmail(user.getEmail());
			}
			if (user.getName() != null && user.getName().isEmpty() == false) {
				foundUser.setName(user.getName());
			}
			if (user.getPassword() != null && user.getPassword().isEmpty() == false) {
				foundUser.setPassword(user.getPassword());
			}
			if (user.getState() != null && user.getState().isEmpty() == false) {
				foundUser.setState(user.getState());
			}
			userRepository.save(foundUser);
			return "update completed";

		} catch (NoSuchElementException e) {
			throw new UserNotFoundException();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "An error accured, please check console";
		}

	}
	
	@DeleteMapping("/delete")
	public @ResponseBody String deleteUser(@RequestParam(name="id") Integer id) {
		try {
			userRepository.deleteById(id);
			return "deleted";
			
		}catch(NoSuchElementException | EmptyResultDataAccessException e) {
			throw new UserNotFoundException();
		}
		
	}
}
