package exam.repository;

import exam.model.dto.ExportDTO;
import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Laptop findByMacAddress(String macAddress);

    @Query("select new exam.model.dto.ExportDTO(l.macAddress, l.cpuSpeed, l.ram, l.storage, l.price, s.name, t.name) from Laptop l join l.shop s join s.town t order by l.cpuSpeed desc, l.ram desc, l.storage desc, l.macAddress asc")
    List<ExportDTO> findAllLaptops();


}
