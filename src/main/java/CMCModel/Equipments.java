package CMCModel;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class Equipments {

	public Equipments() {
	}


	public Equipments(Long id, String equipmentName, LocalDate serviceDate, LocalDate defectedDate) {
		super();
		this.id = id;
		this.equipmentName = equipmentName;
		this.serviceDate = serviceDate;
		this.defectedDate = defectedDate;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@JsonFormat
	private String equipmentName;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate serviceDate;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate defectedDate;
	

	@OneToMany(mappedBy = "equipments",cascade={CascadeType.ALL})
	@JsonIgnore
	private List<CheckUp> checkUp;
}
