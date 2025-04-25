package ijse.lk.CrudDemo.Dao;

import ijse.lk.CrudDemo.Entity.Student;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student theStudent);
    Student findById(int studentId);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
}
