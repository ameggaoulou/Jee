package com.example.absenceservice.Service;

import com.example.absenceservice.Model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseRestClient {
    @GetMapping(path="/courses/{id}")
    Course findCourseById(@PathVariable Long id);
}
