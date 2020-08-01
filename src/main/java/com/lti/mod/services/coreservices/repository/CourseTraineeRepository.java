package com.lti.mod.services.coreservices.repository;

import com.lti.mod.services.coreservices.model.CourseTrainee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseTraineeRepository extends JpaRepository<CourseTrainee, Long> {

    List<CourseTrainee> findByCourseMentorId(Long mentorId);

    List<CourseTrainee> findByTraineeId(Long traineeId);

}
