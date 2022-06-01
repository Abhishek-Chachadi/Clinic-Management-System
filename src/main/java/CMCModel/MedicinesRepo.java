package CMCModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicinesRepo extends JpaRepository<Medicines, Long> {
	@Query(value = "select * from medicines where id = ?1", nativeQuery =true)
	Medicines findByMedicineID(Object medicinesID);

}
