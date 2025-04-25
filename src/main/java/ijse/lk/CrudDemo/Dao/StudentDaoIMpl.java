package ijse.lk.CrudDemo.Dao;


import ijse.lk.CrudDemo.Entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
