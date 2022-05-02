package hiberspring.repository;


import hiberspring.domain.dtos.ExportDTO;
import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("SELECT new hiberspring.domain.dtos.ExportDTO(CONCAT(e.firstName, ' ', e.lastName), e.position, e.employeeCard.number) FROM Employee e join e.employeeCard ec join e.branch b where size(b.products) > 0 order by CONCAT(e.firstName, ' ', e.lastName) asc, length(e.position) desc ")
    List<ExportDTO> exportEmployees();

}
