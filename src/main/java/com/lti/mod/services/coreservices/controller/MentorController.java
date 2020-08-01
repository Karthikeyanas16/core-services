package com.lti.mod.services.coreservices.controller;

import com.lti.mod.services.coreservices.model.User;
import com.lti.mod.services.coreservices.service.CourseTraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MentorController {

    @Autowired
    private CourseTraineeService courseTraineeService;

    @GetMapping("/api/mentor/trainee/{mentorId}")
    public ResponseEntity<?> findAllTraineeOfMentor(@PathVariable Long mentorId) {
        List<User> trainees = courseTraineeService.findAllTraineesOfMentor(mentorId).stream().map(cs -> cs.getTrainee()).collect(Collectors.toList());
        return new ResponseEntity<>(trainees, HttpStatus.OK);

    }

}
