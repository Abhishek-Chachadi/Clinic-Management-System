package CMCModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	@Query(value = "select * from Customer where id = ?1",nativeQuery = true)
	Customer findByCustomerName(Long patientsID);

}
