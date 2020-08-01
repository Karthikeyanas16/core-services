package com.lti.mod.services.coreservices.service;

import com.lti.mod.services.coreservices.model.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(Long courseId);

    List<Course> findAllCourses();
}
