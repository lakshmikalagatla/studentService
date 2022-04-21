package com.student.StudentManagment.DTOs;

public class TransactionRequest {
    Integer StudentId;

    public TransactionRequest(Integer studentId, StudentDTO paymentDetails) {
        StudentId = studentId;
        this.paymentDetails = paymentDetails;
    }

    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public StudentDTO getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(StudentDTO paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    StudentDTO paymentDetails;
}
