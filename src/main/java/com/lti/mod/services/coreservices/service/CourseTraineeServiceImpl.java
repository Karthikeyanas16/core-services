package com.lti.mod.services.coreservices.service;

import com.lti.mod.services.coreservices.model.CourseTrainee;
import com.lti.mod.services.coreservices.repository.CourseTraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseTraineeServiceImpl implements CourseTraineeService {

    @Autowired
    private CourseTraineeRepository courseTraineeRepository;

    @Override
    public CourseTrainee saveCourseTrainee(CourseTrainee courseTrainee) {
        return courseTraineeRepository.save(courseTrainee);
    }

    @Override
    public List<CourseTrainee> findAllCoursesOfTrainee(Long traineeId) {
        return courseTraineeRepository.findByTraineeId(traineeId);
    }

    @Override
    public List<CourseTrainee> findAllTraineesOfMentor(Long mentorId) {
        return courseTraineeRepository.findByCourseMentorId(mentorId);
    }

    @Override
    public List<CourseTrainee> findAllEnrollments() {
        return courseTraineeRepository.findAll();
    }



}
