package com.example.crmdemo.main.service;

import java.util.List;

import com.example.crmdemo.main.dto.UserDTO;
import com.example.crmdemo.main.model.Course;
import com.example.crmdemo.main.model.PurchaseCourse;
import com.example.crmdemo.main.model.User;

public interface UserService {

	public UserDTO register(UserDTO udto,String rawPassword);
	
	public UserDTO login(String email, String password);
	
    public UserDTO toDTO(User user) ;
	
	List<Course>viewCourses();
	
   PurchaseCourse purchaseNewCourse(Long userId, Long courseId);



}
