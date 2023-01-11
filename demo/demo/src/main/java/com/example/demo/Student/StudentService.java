package com.example.demo.Student;

import com.example.demo.dto.StudentDto;
import com.example.demo.exception.FieldsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Component the component and service are the same, used service for clarity.
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
    public StudentService(){

    }

    public List<Student> getStudent() {
       return studentRepository.findAll();
    }
    public void addNewStudent(Student student){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw  new IllegalStateException("Email already exist.");
        }
        studentRepository.save(student);
    }
    public  void deleteStudent(Long studentId){
        Optional<Student> byId = studentRepository.findById(studentId);

        if(byId.isEmpty()){
            throw new IllegalStateException(("Student does not exist"));
        }
        studentRepository.deleteById(studentId);


    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public StudentDto updateStudent(@NotNull StudentDto studentDto) throws FieldsNotFoundException {

      //  if(studentDto !=null)
        Student student = studentRepository.getById(studentDto.getId());
    if(Objects.nonNull(student)) {

        if (studentDto.getName() != null && studentDto.getName().length() > 0) {
            student.setName(studentDto.getName());
        }
        if (studentDto.getEmail() != null && studentDto.getEmail().length() > 0) {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(studentDto.getEmail());
            if (studentByEmail.isPresent()) {
                System.out.println("Student email :" + studentByEmail.get());
                throw new IllegalStateException("Email already exist.");
            }
            student.setEmail(studentDto.getEmail());
        }
        Student updatedStudent = studentRepository.saveAndFlush(student);
        StudentDto updateStudentDto = new StudentDto();
        updateStudentDto.setId(updatedStudent.getId());
        updateStudentDto.setName(updatedStudent.getName());
        updateStudentDto.setEmail(updatedStudent.getEmail());
        updateStudentDto.setDob(updatedStudent.getDob());

        return updateStudentDto;
    }
    throw new FieldsNotFoundException("No records found" );
    }

}
