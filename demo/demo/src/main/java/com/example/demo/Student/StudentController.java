package com.example.demo.Student;

import com.example.demo.dto.StudentDto;
import com.example.demo.exception.FieldsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity< List<Student>> getStudent() {

        return ResponseEntity.ok(studentService.getStudent());

    }
    @PostMapping
    public ResponseEntity registerStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping(path = "{studentId}")
    public ResponseEntity deleteStudent(@PathVariable("studentId") @NotNull Long id){
    studentService.deleteStudent(id);
    return ResponseEntity.noContent().build();

    }
    @PutMapping(path = "{studentId}")
    public ResponseEntity updateStudent(@PathVariable("studentId") @NotNull Long id, @RequestBody @NotNull StudentDto studentDto) throws FieldsNotFoundException {
      studentService.updateStudent(studentDto);
      return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
