package com.example.crmdemo.main.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crmdemo.exceptionhandling.ResourceNotFoundException;
import com.example.crmdemo.main.dto.UserDTO;
import com.example.crmdemo.main.model.Course;
import com.example.crmdemo.main.model.PurchaseCourse;
import com.example.crmdemo.main.model.User;
import com.example.crmdemo.main.repositories.CourseRepository;
import com.example.crmdemo.main.repositories.PurchaseCourseRepository;
import com.example.crmdemo.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepo;
	@Autowired
	CourseRepository courserepo;
	@Autowired
	PurchaseCourseRepository purchrepo;

	@Override
	public UserDTO register(UserDTO udto, String rawPassword) {
		User u1 = new User();
		u1.setName(udto.getName());
		u1.setEmail(udto.getEmail());
		u1.setPassword(rawPassword);
		u1.setPhoneno(udto.getPhoneno());
		u1.setCity(udto.getCity());
		System.out.println("New user Successfully Registred ");
		return toDTO(userrepo.save(u1));
	}

	@Override
	public UserDTO login(String email, String password) {
		User u2 = userrepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
		System.out.println("login  Successfully  ");

		if (!u2.getPassword().equals(password)) {
			throw new RuntimeException("Invalid Email or Password ");
		}

		return toDTO(u2);
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPhoneno(user.getPhoneno());
		dto.setCity(user.getCity());

		return dto;

	}

	@Override
	public List<Course> viewCourses() {
		// TODO Auto-generated method stub
		System.out.println("View all courses list on crm   ");

		return courserepo.findAll().stream().sorted(Comparator.comparing(Course::getOriginalPrice))
				.collect(Collectors.toList());
	}

	public PurchaseCourse purchaseNewCourse(Long userId, Long courseId) {
		User user = userrepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found this id "));

		Course course = courserepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course  not found this id"));

		System.out.println(" Course Purchase by Registred user ");
		PurchaseCourse purchase = PurchaseCourse.builder().user(user).course(course).purchaseDate(LocalDateTime.now())
				.build();

		return purchrepo.save(purchase);
	}

}
