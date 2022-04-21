package com.student.StudentManagment.Repository;

import com.student.StudentManagment.Beans.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRespository extends CrudRepository<Student, Integer> {
    @Query("select s from Student s where s.name like %:name%")
    public List<Student> searchByName(@Param("name") String name);
}
