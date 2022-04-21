package com.student.StudentManagment.DTOs;

import com.student.StudentManagment.Beans.Student;

import java.util.List;

public class TransactionResponse {
    Student stud;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public TransactionResponse(Student stud, String message) {
        this.stud = stud;
        this.message = message;
    }

    public Student getStud() {
        return stud;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }

}
