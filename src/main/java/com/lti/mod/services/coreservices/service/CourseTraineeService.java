package com.lti.mod.services.coreservices.service;

import com.lti.mod.services.coreservices.model.CourseTrainee;

import java.util.List;

public interface CourseTraineeService {
    CourseTrainee saveCourseTrainee(CourseTrainee courseTrainee);

    List<CourseTrainee> findAllCoursesOfTrainee(Long TraineeId);

    List<CourseTrainee> findAllTraineesOfMentor(Long mentorId);

    List<CourseTrainee> findAllEnrollments();
}
