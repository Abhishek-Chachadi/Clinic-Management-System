package CMCModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
public class Customer {

	public Customer() {

	}

	public Customer(String firstName, String lastName, int age, String sex, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private String sex;

	@Column(nullable = false)
	private String address;
	
	@OneToMany(mappedBy = "patients",cascade={CascadeType.ALL})
	@JsonIgnore
	private List<CheckUp> checkUp;

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
		
	}
	

}

