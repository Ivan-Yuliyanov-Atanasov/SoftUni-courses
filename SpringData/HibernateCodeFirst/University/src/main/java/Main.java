import entities.Person;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("softuni").
                createEntityManager();


        entityManager.getTransaction().begin();
        Person student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        Person teacher = new Teacher();
        teacher.setFirstName("Ivan");
        teacher.setLastName("Ivanov");
        entityManager.persist(student);
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }
}

