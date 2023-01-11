package com.example.service;

import com.example.demo.Student.Student;
import com.example.demo.Student.StudentRepository;
import com.example.demo.Student.StudentService;
import com.example.demo.dto.StudentDto;
import com.example.demo.exception.FieldsNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Spy //spy on the entity
    private Student student = new Student();
  //  private Optional<Student> optionalStudent;

    @Spy
    private StudentDto studentDto = new StudentDto();

    @InjectMocks
     StudentService studentService;

    @BeforeEach //to initialize objects annotated with @Mock, @Spy, @Captor, or @InjectMocks
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        student.setId(5L);
        student.setName("StudentName");
        student.setEmail("new@gmail.com");
        student.setDob(LocalDate.parse("1980-10-10"));
        student.setAge(42);

//        optionalStudent = Optional.of(student);


    }
    @AfterEach
    public void tearDown(){
    studentDto=null;
    }
    @Test
    void shouldUpdateStudent() throws IllegalStateException, FieldsNotFoundException {
        StudentDto expectedStudDto = new StudentDto();
        expectedStudDto.setId(5L);
        expectedStudDto.setName("Chumani");
        expectedStudDto.setEmail("chumani@cue.com");
        expectedStudDto.setDob(LocalDate.parse("2010-10-10"));
        expectedStudDto.setAge(20);

        when(studentRepository.getById(anyLong())).thenReturn(student);//or call the method
        when(studentRepository.saveAndFlush(any(Student.class))).thenReturn(student);
       // when(studentRepository.saveAndFlush(any(Student.class))).thenReturn(getStudent());

        StudentDto updateUser = studentService.updateStudent(expectedStudDto);
        verify(studentRepository, times(1)).saveAndFlush(any(Student.class));
        verify(studentRepository, times(1)).getById(anyLong());

        Assertions.assertEquals(expectedStudDto.getId(), updateUser.getId());
    }

    @Test
    void shouldGetAll(){
        Student students = new Student();

    //when(studentRepository.findAll()).thenReturn(students.);
    List<Student> studentList = studentService.getStudent();

    }

    private Student getStudent() {
       Student student = new Student();
        student.setId(5L);
        student.setName("StudentName");
        student.setEmail("ts@gmail.com");
        student.setDob(LocalDate.parse("1980-10-10"));
        student.setAge(42);
        return student;
    }

//    @Test
//    void shouldUpdateFail(){
//
//        when(studentRepository.getById(anyLong())).thenReturn(null);
//        Assertions.assertThrows(FieldsNotFoundException.class, () -> studentService.updateStudent(studentDto));
//
//    }
    @Test
    void should_Not_UpdateStudent_IDNull() {

        Assertions.assertThrows(NullPointerException.class, () -> studentService.updateStudent(null));


    }
    @Test
    void shouldDeleteStudent(){
        when(studentRepository.findById(anyLong())).thenReturn(buildStudent());
        studentService.deleteStudent(getStudent().getId());
        verify(studentRepository, times(1)).deleteById(anyLong());

    }
    @Test
    void shouldAddUser(){
       // student.setId(null);

        when(studentRepository.save(any(Student.class))).thenReturn(student);
        studentService.addNewStudent(student);
        verify(studentRepository,times(1)).save(any(Student.class));


    }
    @Test
    void shouldNotAddStudent(){

        when(studentRepository.findStudentByEmail(anyString())).thenReturn(buildStudent());
        Assertions.assertThrows(IllegalStateException.class, () ->studentService.addNewStudent(student));
        verify(studentRepository, times(1)).findStudentByEmail(anyString());

    }

    private Optional<Student> buildStudent() {
        Optional<Student> optionalStudent = Optional.of(getStudent());
        return  optionalStudent;
    }


}
