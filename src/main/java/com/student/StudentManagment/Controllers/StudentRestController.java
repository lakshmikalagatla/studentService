package com.student.StudentManagment.Controllers;

import com.student.StudentManagment.Beans.Student;
import com.student.StudentManagment.DTOs.StudentDTO;
import com.student.StudentManagment.DTOs.TransactionResponse;
import com.student.StudentManagment.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public ResponseEntity getStudentsByPath(@PathVariable("id") Integer id) {
        Optional<Student> student = studentService.findByStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public TransactionResponse updateStudent(@PathVariable("id") Integer studentid, @RequestBody StudentDTO updatedpayment) {
            System.out.println("Entered Student Service");
            return studentService.updateStudent(studentid, updatedpayment);
    }

}
