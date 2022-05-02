import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Please enter exercise number:");

        try {
            int exerciseNumber = Integer.parseInt(reader.readLine());
            switch (exerciseNumber) {
                case 2:
                    exerciseTwo();
                    break;
                case 3:
                    exerciseThree();
                    break;
                case 4:
                    exerciseFour();
                    break;
                case 5:
                    exerciseFive();
                    break;
                case 6:
                    exerciseSix();
                    break;
                case 7:
                    exerciseSeven();
                    break;
                case 8:
                    exerciseEight();
                    break;
                case 9:
                    exerciseNine();
                    break;
                case 10:
                    exerciseTen();
                    break;
                case 11:
                    exerciseEleven();
                    break;
                case 12:
                    exerciseTwelve();
                    break;
                case 13:
                    exerciseThirteen();
                    break;


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    private void exerciseThirteen() throws IOException {

        System.out.println("Please enter town name:");
        String townName = reader.readLine();

        Town townToBeDeleted = entityManager.createQuery("SELECT t FROM Town t WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.town.name = :t_name", Address.class)
                .setParameter("t_name", townName)
                .getResultList();

        System.out.printf("%d address%s in %s deleted%n", addresses.size(), (addresses.size() != 1) ? "es" : "", townToBeDeleted.getName());

        entityManager.getTransaction().begin();
        addresses.stream()
                .forEach(a -> {
                    a.setTown(null);
                    a.getEmployees().stream().forEach(e -> e.setAddress(null));
                    entityManager.remove(a);
                });
        entityManager.remove(townToBeDeleted);

        entityManager.getTransaction().commit();

    }

    @SuppressWarnings("unchecked")
    private void exerciseTwelve() {
        StringBuilder output = new StringBuilder();
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS max_salary FROM departments AS d " +

                "JOIN employees e on d.department_id = e.department_id " +
                "GROUP BY d.department_id " +
                "HAVING max_salary NOT BETWEEN 30000 AND 70000").getResultList();

        resultList.stream().forEach(object -> output.append(object[0]).append(" ").append(object[1]).append(System.lineSeparator()));
        System.out.println(output.toString().trim());


    }

    private void exerciseEleven() throws IOException {
        System.out.println("Please the starting letters of the first name:");
        String startingLetters = reader.readLine().trim();
        entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE :param", Employee.class)
                .setParameter("param", startingLetters + "%")
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }

    private void exerciseTen() {

        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e SET e.salary = 1.12 * e.salary WHERE e.department.id IN(1,2,4,11)").executeUpdate();

        entityManager.getTransaction().commit();


        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = 'Engineering' OR e.department.name = 'Tool Design'" +
                        " OR e.department.name = 'Marketing' OR e.department.name = 'Information Services'", Employee.class).getResultStream().
                forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void exerciseSix() throws IOException {
        System.out.println("Please enter employee last name:");
        String employeeLastName = reader.readLine();
        Address address = new Address();
        address.setText("Vitoshka 15");

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", employeeLastName)
                .getSingleResult();
        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private void exerciseNine() {



        StringBuilder output = new StringBuilder();
        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p order by p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();
        projects.stream().sorted(Comparator.comparing(Project::getName)).forEach(p -> output
                .append("Project name: ").append(p.getName()).append(System.lineSeparator())
                .append("\tProject Description: ").append(p.getDescription()).append(System.lineSeparator())
                .append("\tProject Start Date: ").append(p.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s"))).append(System.lineSeparator())
                .append("\tProject End Date: ").append(p.getEndDate() == null ? "null" : p.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s"))).append(System.lineSeparator()));
        System.out.println(output.toString().trim());
    }




    private void exerciseEight() throws IOException {
        System.out.println("Please enter employee id:");
        int employeeId = Integer.parseInt(reader.readLine());
        Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = : e_id", Employee.class)
                .setParameter("e_id", employeeId)
                .getSingleResult();
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().stream().map(Project::getName).sorted().forEach(p -> System.out.printf("\t%s%n", p));


    }

    private void exerciseSeven() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();
        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees%n", address.getText(), address.getTown().getName(), address.getEmployees().size());
        }

    }

    private void exerciseFive() {

        entityManager.createQuery("SELECT e FROM Employee e WHERE e.department.name = 'Research and Development'" +
                        "ORDER BY e.salary, e.id ", Employee.class).getResultStream().
                forEach(e -> System.out.printf("%s %s from Research and Development - $%.2f%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void exerciseFour() {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.salary > 50000", Employee.class).getResultList();
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }

    }

    private void exerciseThree() throws IOException {
        System.out.println("Please enter employee full name:");
        String[] fullName = reader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long isEmployeePresent = entityManager.createQuery("SELECT count(e) FROM Employee e WHERE  e.firstName = :f_name AND e.lastName = :l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();
        String output = isEmployeePresent == 1 ? "Yes" : "No";
        System.out.println(output);
    }

    private void exerciseTwo() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town SET name = UPPER(name) WHERE length(name) <= 5");
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

}

