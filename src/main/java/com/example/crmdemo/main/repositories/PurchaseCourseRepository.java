package com.example.crmdemo.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crmdemo.main.model.PurchaseCourse;
import com.example.crmdemo.main.model.User;

public interface PurchaseCourseRepository extends JpaRepository<PurchaseCourse, Long> {

	List<PurchaseCourse> findByUser(User user);

}
