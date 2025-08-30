package com.example.crmdemo.main.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.crmdemo.exceptionhandling.ResourceNotFoundException;
import com.example.crmdemo.main.model.Course;
import com.example.crmdemo.main.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository coursrepo;

	@Override
	public Course addCourse(Course course) {
		System.out.println("New course Created Successfully !");
		return coursrepo.save(course);
	}

	@Override
	public List<Course> getAllSorted(String sortBy) {
		List<Course> all = coursrepo.findAll();
		Comparator<Course> comprt = Comparator.comparing(Course::getName);

		if ("originalPrice".equalsIgnoreCase(sortBy)) {

			comprt = Comparator.comparing(Course::getOriginalPrice);

		} else if ("id".equalsIgnoreCase(sortBy)) {

			comprt = Comparator.comparing(Course::getId);
		}

		else if ("updatedOn".equalsIgnoreCase(sortBy)) {
			comprt = Comparator.comparing(Course::getUpdatedOn);
		}

		System.out.println(" All course Sorted by price or Name  ");

		return all.stream().sorted(comprt).collect(Collectors.toList());

	}

	@Override
	public Course getCourseDetailsBYCourseName(String name) {
		// TODO Auto-generated method stub
		System.out.println(" Course detail search by course name ");

		return coursrepo.findByName(name);
	}

	// Pageable is used to specify pagination information i.e. page number, page
	// size, sorting order etc when querying with database
	// Page represents the chunk of data that is fetched according to pagination
	// parameters defined by Pagable.
	@Override
	public Page<Course> getAllCourseDetailsByPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		System.out.println(" Course detail search by using paginaton ");

		return coursrepo.findAll(pageable);
	}

	@Override
	public List<Course> getAllCourseDetails() {

		System.out.println(" List Out All Course Details ");

		return coursrepo.findAll();
	}

	@Override
	public Course updateCourseDetailsById(Long id, Course updatedCourse) {
		// TODO Auto-generated method stub
		Course existingCourse = coursrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found on this Id "));

		existingCourse.setName(updatedCourse.getName());
		existingCourse.setDescription(updatedCourse.getDescription());
		existingCourse.setOriginalPrice(updatedCourse.getOriginalPrice());
		existingCourse.setDiscountedPrice(updatedCourse.getDiscountedPrice());
		existingCourse.setUpdatedOn(updatedCourse.getUpdatedOn());

		System.out.println("Course Detailed updated by Existing Course Id ");

		return coursrepo.save(existingCourse);

	}

	@Override
	public Course getCourseDeatilsById(Long id) {
		System.out.println("Course Detailed fetch  by Existing Course Id ");
		Course existingCourse = coursrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course Detail  not found on this Id "));
		;
		return existingCourse;
	}

	@Override
	public List<String> getAllCourseNames() {
		// TODO Auto-generated method stub
System.out.println("All Course Name Listed only  ");
		return coursrepo.findAll().stream()
.map(Course::getName).collect(Collectors.toList());

	
	
	}

	@Override
	public void deleteCourseDetails(String courseName) {
		
	Course course=coursrepo.findByName(courseName);
	System.out.println("Selected  Course by id  deleted successfully ");
	
	
	if (course !=null) {
		
		coursrepo.delete(course);
		
	} else {

		throw new RuntimeException("Course for found with this name "+courseName);
		
		
	}
		
		
		
		
		
		
		
		
		
	}

}
