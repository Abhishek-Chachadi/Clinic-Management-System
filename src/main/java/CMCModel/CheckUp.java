package CMCModel;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class CheckUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String findings;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate checkInDate;

	@Column(nullable = false)
	private String complaints;

	@Column(nullable = false)
	private double quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JsonIgnore
	private Customer patient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JsonIgnore
	private Treatments treatMethod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JsonIgnore
	private Equipments equipments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonManagedReference
	@JsonIgnore
	private Medicines drugs;

}
