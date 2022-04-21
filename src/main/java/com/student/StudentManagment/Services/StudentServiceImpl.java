package com.student.StudentManagment.Services;

import com.student.StudentManagment.Beans.Student;
import com.student.StudentManagment.DTOs.StudentDTO;
import com.student.StudentManagment.DTOs.TransactionRequest;
import com.student.StudentManagment.DTOs.TransactionResponse;
import com.student.StudentManagment.Repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private RestTemplate template;

    @Override
    public Integer createStudent(Student student) {
        return studentRespository.save(student).getId();
    }

    @Override
    public Optional<Student> findByStudent(int id) {
        return studentRespository.findById(id);
    }

    @Override
    public TransactionResponse updateStudent(int id, StudentDTO payment) {
        String response = "";
        if (studentRespository.findById(id).isPresent()) {
            Student existStudent = studentRespository.findById(id).get();
            TransactionRequest request = new TransactionRequest(existStudent.getId(), payment);
            /*Fee fee = new Fee();
            fee.setAmount(student.getAmount());
            fee.setType(student.getType());
            existStudent.getFeePaymentList().add(fee);*/
            System.out.println("Calling Fee Service");
            HttpStatus status = template.postForObject("http://FEE-SERVICE/dopayment",request,HttpStatus.class);

            response = (status==HttpStatus.OK)?"Student Paid Fee":"There is a failure";
            System.out.println(response);
            return new TransactionResponse(existStudent,response);
        } else
            return null;
    }

}
