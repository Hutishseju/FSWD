package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/listResult")
    public List<Result> getAllStudents() {
        return resultRepository.findAll();
    }

    @GetMapping ("Result/{id}")
    public Result getResult(@PathVariable Integer id) {
        return resultRepository.findById(id).get();
    }

    @PostMapping("/Result")
    public List<Result> addResult(@RequestBody Result result) {
        resultRepository.save(result);
        return resultRepository.findAll();
    }
    @DeleteMapping("/Result/{id}")
    public List<Result> deleteCourse(@PathVariable Integer id) {
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }

    // Update the student information
    @PutMapping("/Result/{id}")
    public List<Result> updateResult(@RequestBody Result result, @PathVariable Integer id) {
        Result resultObj1 = resultRepository.findById(id).get();
        resultObj1.setTitle(result.getTitle());
        resultObj1.setDescription(result.getDescription());
        resultRepository.save(resultObj1);
        return resultRepository.findAll();
    }

}
