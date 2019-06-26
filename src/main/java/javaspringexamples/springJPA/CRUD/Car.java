package javaspringexamples.springJPA.CRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
@Entity
public class Car {
	@Id
	@GeneratedValue
	private Long id;

	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getId() {
		return id;
	}
}