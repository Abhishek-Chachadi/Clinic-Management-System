package CMCModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TreatmentsRepo extends JpaRepository<Treatments, Long> {
	@Query(value = "select * from Treatments where id = ?1", nativeQuery = true)
	Treatments findByTreatmentID(Object treatmentID);

}
