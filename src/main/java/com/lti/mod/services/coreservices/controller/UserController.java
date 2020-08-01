package com.lti.mod.services.coreservices.controller;

import com.lti.mod.services.coreservices.jwt.JwtTokenProvider;
import com.lti.mod.services.coreservices.model.CourseTrainee;
import com.lti.mod.services.coreservices.model.User;
import com.lti.mod.services.coreservices.service.CourseService;
import com.lti.mod.services.coreservices.service.CourseTraineeService;
import com.lti.mod.services.coreservices.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private Environment env;

    @Value( "${spring.application.name}")
    private String serviceId;

    @GetMapping("/service/port")
    public String getPort() {
        return "Service port number :" + env.getProperty("local.server.port");
    }

    @GetMapping("/service/instances")
    public ResponseEntity<?> getInstances() {
        return new ResponseEntity<>(discoveryClient.getInstances(serviceId),  HttpStatus.OK);
    }

    @Autowired
    private CourseTraineeService courseTraineeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/service/services")
    public ResponseEntity<?> getServices() {
        return new ResponseEntity<>(discoveryClient.getServices(), HttpStatus.OK);
    }


    @PostMapping("/service/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()) != null ) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //user.setRole(Role.TRAINEE);
        System.out.println("User Role -->"+user.getRole());
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/service/user/login")
    public ResponseEntity<?> getUser(Principal principal){
        if(principal == null ) {
            //This should be ok http status because here will be logout path.
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) principal;
        LOGGER.info("Login user");
        User user = userService.findByUsername(authenticationToken.getName());
        LOGGER.info("Logged User : {}",user.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("/service/user/enroll")
    public ResponseEntity<?> enrollCourse(@RequestBody CourseTrainee courseTraniee){
        return new ResponseEntity<>(courseTraineeService.saveCourseTrainee(courseTraniee), HttpStatus.CREATED);
    }

    @GetMapping("/service/user/courses")
    public ResponseEntity<?> getAllCourses(){
        return ResponseEntity.ok(courseService.findAllCourses());
    }

}
