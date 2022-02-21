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
	CheckUpRepo checkuprepo;
	@Autowired
	CustomerRepo customerrepo;
	@Autowired
	EquipmentsRepo equipmentrepo;
	@Autowired
	TreatmentsRepo treatmentrepo;
	@Autowired
	MedicinesRepo medicinerepo;

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public ResponseEntity<Object> createCustomer(@RequestBody Customer cmp) {

		customerrepo.save(cmp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmp.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}


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
	
	@PostMapping("/checkup")
	CheckUp newCheckup(@RequestBody CheckUp newCheckup) {
		return checkuprepo.save(newCheckup);
	}

	
	
	
	
	
}
