package com.lti.mod.services.coreservices.controller;

import com.lti.mod.services.coreservices.model.Course;
import com.lti.mod.services.coreservices.model.CourseTrainee;
import com.lti.mod.services.coreservices.service.CourseTraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TraineeController {

    @Autowired
    private CourseTraineeService courseTraineeService;

    @GetMapping("/api/trainee/courses/{traineeId}")
    public ResponseEntity<?> findAllCoursesOfTrainee(@PathVariable Long studentId) {
        List<Course> courseList = courseTraineeService.findAllCoursesOfTrainee(studentId).stream().map(cs -> cs.getCourse()).collect(Collectors.toList());
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }

    @PostMapping("/api/trainee/enroll")
    public ResponseEntity<?> enroll(@RequestBody CourseTrainee courseTrainee) {
        return new ResponseEntity<>(courseTraineeService.saveCourseTrainee(courseTrainee), HttpStatus.CREATED);
    }

}
