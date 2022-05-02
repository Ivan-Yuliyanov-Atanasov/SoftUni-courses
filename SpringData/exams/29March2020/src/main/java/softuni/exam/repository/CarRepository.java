package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.dto.ExportCarDTO;
import softuni.exam.models.entity.Car;

import java.util.List;

//ToDo
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select new softuni.exam.models.dto.ExportCarDTO(c.make, c.model, c.kilometers, c.registeredOn, size(c.pictures)) from Car c group by c.id order by size(c.pictures) desc, c.make asc ")
    List<ExportCarDTO> exportCars();

}
