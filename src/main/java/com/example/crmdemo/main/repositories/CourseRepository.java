package com.example.crmdemo.main.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crmdemo.main.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long >{

	
	Course findByName(String name);
	
	
}
