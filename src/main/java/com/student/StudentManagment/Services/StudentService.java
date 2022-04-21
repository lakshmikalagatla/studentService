package com.student.StudentManagment.Services;

import com.student.StudentManagment.Beans.Student;
import com.student.StudentManagment.DTOs.StudentDTO;
import com.student.StudentManagment.DTOs.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentService {
    public Integer createStudent(Student student);

    public Optional<Student> findByStudent(int id);

    public TransactionResponse updateStudent(int id, StudentDTO student);
}
