package com.example.crmdemo.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.crmdemo.main.dto.UserDTO;
import com.example.crmdemo.main.model.Course;
import com.example.crmdemo.main.model.PurchaseCourse;
import com.example.crmdemo.main.service.UserServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserServiceImpl userv;

	@PostMapping("/register")
	public UserDTO register(@RequestBody @Valid UserDTO dto, @RequestParam String password) {
		System.out.println("New User Registred Successfuly ");
		return userv.register(dto, password);
	}

	@PostMapping("/login")
	public UserDTO Login(@RequestParam String email, @RequestParam String password) {
		System.out.println("login Successfuly ");

		return userv.login(email, password);

	}

	@GetMapping("/courses")
	public List<Course> ViewAllCourses() {
		// TODO Auto-generated method stub
		System.out.println("View all courses list on crm via Controller   ");

		return userv.viewCourses();
	}

	@PostMapping("/{userId}/purchase/{courseId}")
	public PurchaseCourse purchaseNewCourse(@PathVariable Long userId, @PathVariable Long courseId) {

		System.out.println("purchase course mappded in  crm via Controller   ");

		return userv.purchaseNewCourse(userId, courseId);

	}

}
