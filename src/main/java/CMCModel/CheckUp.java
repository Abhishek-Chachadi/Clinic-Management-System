package CMCModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CHECKUP_ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFindings() {
		return findings;
	}

	public void setFindings(String findings) {
		this.findings = findings;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Customer getPatients() {
		return patients;
	}

	public void setPatients(Customer patients) {
		this.patients = patients;
	}

	@Column(nullable = false)
	@JsonFormat
	private String findings;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate checkInDate;

	@Column(nullable = false)
	@JsonFormat
	private String complaints;

	@Column(nullable = false)
	@JsonFormat
	private double quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Customer patients;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Equipments equipments;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Medicines medicines;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Treatments treatments;
	
	public Treatments getTreatments() {
		return treatments;
	}

	public void setTreatments(Treatments treatments) {
		this.treatments = treatments;
	}

	@Transient
	public Long patientsID;

	public Medicines getMedicines() {
		return medicines;
	}

	public void setMedicines(Medicines medicines) {
		this.medicines = medicines;
	}

	public Long getPatientsID() {
		return patientsID;
	}

	public void setPatientsID(Long patientsID) {
		this.patientsID = patientsID;
	}
	
	
	@Transient
	public Long equipmentsID;
	@Transient
	public Object medicinesID;
	@Transient
	public Object treatmentID;

	public Object getTreatmentID() {
		return treatmentID;
	}

	public void setTreatmentID(Object treatmentID) {
		this.treatmentID = treatmentID;
	}

	public Object getMedicinesID() {
		return medicinesID;
	}

	public void setMedicinesID(Object medicinesID) {
		this.medicinesID = medicinesID;
	}

	public Equipments getEquipments() {
		return equipments;
	}

	public void setEquipments(Equipments equipments) {
		this.equipments = equipments;
	}

	public Long getEquipmentsID() {
		return equipmentsID;
	}

	public void setEquipmentsID(Long equipmentsID) {
		this.equipmentsID = equipmentsID;
	}

	

	
	
	//private String patientID;


//
//	public String getCustomerName() {
//		return customerName;
//	}
//
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//
//	public void setCustomer(Customer se) {
//		this.patients = se;
//	}
//
//	public Long getId() {
//		return id;
//	}

	

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonManagedReference
//	@JsonIgnore
//	@JsonFormat
//	private Treatments treatMethod;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonManagedReference
//	@JsonIgnore
//	@JsonFormat
//	private Equipments equipments;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonManagedReference
//	@JsonIgnore
//	@JsonFormat
//	private Medicines drugs;

}
