package com.example.crmdemo.main.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.crmdemo.main.model.Course;

public interface CourseService {

	public Course addCourse(Course course);

	public List<Course> getAllSorted(String sortBy);

	public Course getCourseDetailsBYCourseName(String name);

	public Course getCourseDeatilsById(Long id);

	public List<Course> getAllCourseDetails();

	public List<String> getAllCourseNames();

	public Page<Course> getAllCourseDetailsByPagination(Pageable pageable);

	public Course updateCourseDetailsById(Long id, Course updatedCourse);

	public void deleteCourseDetails(String courseName);

}