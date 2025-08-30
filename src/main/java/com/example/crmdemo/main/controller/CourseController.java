package com.example.crmdemo.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crmdemo.main.model.Course;
import com.example.crmdemo.main.service.CourseServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	CourseServiceImpl courseservice;

	@PostMapping()

	public Course addCourse(@RequestBody @Valid Course course) {
		System.out.println("Course Controller PostMapping Created Successfully !");
		return courseservice.addCourse(course);
	}

	@GetMapping("/SortedAll")
	public List<Course> getCourseSortedBy(@RequestParam(required = true) String sortBy) {

		System.out.println("Course Controller GetMapping Sorted Course Successfully ");
		return courseservice.getAllSorted(sortBy);

	}

	@GetMapping(value = "/{name}")
	public Course getCourseDetailsBYCourseName(@PathVariable String name) {
		// TODO Auto-generated method stub
		System.out.println("Course detail search by course name by using Get Mapping ");

		return courseservice.getCourseDetailsBYCourseName(name);
	}

	@GetMapping("/All")
	public List<Course> getAllCourseDetails() {

		System.out.println("Get Mapping Controller List Out All Course Details ");

		return courseservice.getAllCourseDetails();
	}

	@GetMapping("/FindById/{id}")
	Course getCourseDeatilsById(@PathVariable Long id) {
		System.out.println("Get Mapping Controller of Course Detailed fetch  by Existing Course Id ");
		return courseservice.getCourseDeatilsById(id);
	}

	@GetMapping("/AllName")
	public List<String> getAllCourseNames() {
		System.out.println("Get Mapping Controller of All Name All Course Name Listed only  ");
		return courseservice.getAllCourseNames();

	}

	@PutMapping(value = "/updateById/{id}")
	public Course updateCourseDetailsById(@PathVariable Long id, @RequestBody Course course) {
		System.out.println("Course Controller is running with  put mapping  updateById  url ");

		return courseservice.updateCourseDetailsById(id, course);

	}
	@DeleteMapping(value = "/DeleteByName/{courseName}")
	public void deleteCourseDetails(@PathVariable String courseName) {
	System.out.println("Course Deleted Successfully using DeleteMapping of controller ");	
	courseservice.deleteCourseDetails(courseName);
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
