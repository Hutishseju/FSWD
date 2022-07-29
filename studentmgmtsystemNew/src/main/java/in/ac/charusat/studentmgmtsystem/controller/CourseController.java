package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
     CourseRepository courseRepository;

    @GetMapping("/listCourses")
    public List<Course> getAllStudents() {
        return courseRepository.findAll();
    }

    @GetMapping ("Course/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseRepository.findById(id).get();
    }

    @PostMapping("/Course")
    public List<Course> addCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return courseRepository.findAll();
    }
    @DeleteMapping("/Course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id) {
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    // Update the student information
    @PutMapping("/Course/{id}")
    public List<Course> updateCourse(@RequestBody Course course, @PathVariable Integer id) {
        Course cousreObj1 = courseRepository.findById(id).get();
        cousreObj1.setTitle(course.getTitle());
        cousreObj1.setDescription(course.getDescription());
        courseRepository.save(cousreObj1);
        return courseRepository.findAll();
    }

}
