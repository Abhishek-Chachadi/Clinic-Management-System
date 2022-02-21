package CMCModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Customer {

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

}
