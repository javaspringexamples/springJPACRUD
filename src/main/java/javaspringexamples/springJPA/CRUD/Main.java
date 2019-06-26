package javaspringexamples.springJPA.CRUD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 * @author mounir.sahrani@gmail.com
 *
 */
public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		// Creating entities
		Person person = new Person();
		person.setFirstName("Jabane");
		person.setLastName("KOLOBANE");
		Car car1 = new Car();
		car1.setModel("R4");
		Car car2 = new Car();
		car2.setModel("R6");
		// Add cars into person's collection
		person.getCars().add(car1);
		person.getCars().add(car2);
		// persisting entities
		entityManager.persist(person);
		System.out.println(person);
		//detaching cars
		long id = person.getId();
		person.getCars().clear();
		System.out.println(person);
		// Delete person
		entityManager.remove(person);
		// find displays null
		person = entityManager.find(Person.class, id);
		System.out.println("Find : " + person);
		// getReference throws javax.persistence.EntityNotFoundException
		person = entityManager.getReference(Person.class, id);
		System.out.println("getReference: " + person);

		transaction.commit();
		entityManager.close();
	}
}
