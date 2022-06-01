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

import org.w3c.dom.Text;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Medicines {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@JsonFormat
	private String drugName;

	@Column(nullable = false)
	@JsonFormat
	private String description;

	@Column(nullable = false)
	@JsonFormat
	private double availableQuantity;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate entryDate;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	
	@OneToMany(mappedBy = "medicines",cascade={CascadeType.ALL})
	@JsonIgnore
	private List<CheckUp> checkUp;

}
