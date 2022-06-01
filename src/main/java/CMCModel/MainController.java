package CMCModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class MainController {

	@Autowired
	private CheckUpRepo checkuprepo;
	@Autowired
	private CustomerRepo customerrepo;
	@Autowired
	private EquipmentsRepo equipmentrepo;
	@Autowired
	private TreatmentsRepo treatmentrepo;
	@Autowired
	private MedicinesRepo medicinerepo;

	/*
	 * @RequestMapping(value = "/customer", method = RequestMethod.POST) public
	 * ResponseEntity<Object> createCustomer(@RequestBody Customer cmp) {
	 * 
	 * customerrepo.save(cmp); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (cmp.getId()) .toUri();
	 * 
	 * return ResponseEntity.created(location).build(); }
	 */


	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return customerrepo.save(newCustomer);
	}
	
	@PostMapping("/equipments")
	Equipments newEquipment(@RequestBody Equipments newEquipments) {
		return equipmentrepo.save(newEquipments);
	}
	
	@PostMapping("/medicines")
	Medicines newMedicines(@RequestBody Medicines newMedicine) {
		return medicinerepo.save(newMedicine);
	}
	
	@PostMapping("/treatments")
	Treatments newTreatments(@RequestBody Treatments newTreatment) {
		return treatmentrepo.save(newTreatment);
	}
	
//	@PostMapping("/checkup")
//	CheckUp newCheckup(@RequestBody CheckUp newCheckup) {
//		return checkuprepo.save(newCheckup);
//	}
//	
	
	@RequestMapping(value = "/checkup", method = RequestMethod.POST)
	public ResponseEntity<Object> createCustomer(@RequestBody CheckUp cmp) {
		System.out.println("----------------------------------------------------------------"+cmp.getQuantity());
		System.out.println("----------------------------------------------------------------"+cmp.toString());
		
		CheckUp testCheckUp = new CheckUp();
		testCheckUp.setCheckInDate(cmp.getCheckInDate());
		testCheckUp.setComplaints(cmp.getComplaints());
		testCheckUp.setFindings(cmp.getFindings());
		testCheckUp.setQuantity(cmp.getQuantity());
		Customer se = customerrepo.findByCustomerName(cmp.patientsID);
		
		System.out.println("----------------------------------------------------------------"+se);
		testCheckUp.setPatients(se);

		checkuprepo.save(testCheckUp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}


	
	
	
	
	
}
