package com.lti.mod.services.coreservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lti.mod.services.coreservices.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
