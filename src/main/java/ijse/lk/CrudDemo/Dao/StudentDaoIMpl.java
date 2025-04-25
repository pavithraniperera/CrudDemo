package ijse.lk.CrudDemo.Dao;


import ijse.lk.CrudDemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoIMpl implements StudentDao {

    private EntityManager entityManager;

    public StudentDaoIMpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //define student save method

    @Override
    @Transactional
    public void saveStudent(Student theStudent){
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(int studentId) {
        return entityManager.find(Student.class,studentId);
    }

    @Override
    public List<Student> findAll() {

      /*  TypedQuery<Student>
        A type-safe version of JPA's Query interface
        Guarantees the results will be Student objects
        Eliminates the need for casting*/

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return  theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

}
