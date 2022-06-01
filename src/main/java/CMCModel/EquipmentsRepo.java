package CMCModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipmentsRepo extends JpaRepository<Equipments, Long> {
	@Query(value = "select * from Equipments where id = ?1",nativeQuery = true)
	Equipments findByEquipmentID(Long equipmentsID);

}
