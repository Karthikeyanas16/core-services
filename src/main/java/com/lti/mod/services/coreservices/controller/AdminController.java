package com.lti.mod.services.coreservices.controller;

import com.lti.mod.services.coreservices.service.CourseTraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private CourseTraineeService courseTraineeService;

    @GetMapping("/api/admin/enrollments")
    public ResponseEntity<?> findAllEnrollments() {
        return ResponseEntity.ok(courseTraineeService.findAllEnrollments());
    }

}
