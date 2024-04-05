package arqweb.aula03.demo.repository;

import arqweb.aula03.demo.config.HibernateConfig;
import org.springframework.stereotype.Repository;
import arqweb.aula03.demo.model.Students;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final SessionFactory sessionFactory;
    public StudentRepositoryImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Students> findAll() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Students> students = session.createQuery("FROM Students", Students.class).getResultList();
        transaction.commit();
        return students;
    }

    @Override
    public Students findById(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Students student = session.find(Students.class, id);
        transaction.commit();
        return student;
    }

    @Override
    @Deprecated(since = "6.0")
    public Students save(Long id, Students student) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(student);
        transaction.commit();
        return student;
    }

    @Override
    public Students delete(Long id){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hqlQuery = "DELETE FROM Students WHERE id = :studentId";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("studentId", id);

        int deletedCount = query.executeUpdate();
        transaction.commit();

        if (deletedCount > 0) {
            return new Students();
        } else {
            return null;
        }
    }

}