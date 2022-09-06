package no.hvl.dat250.jpa.assignment2;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;
    @ManyToMany
    private Set<Person> owners;
    
    public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	public void setOwners(Set<Person> owners) {
		this.owners = owners;
	}

	public Set<Person> getOwners() {
		return owners;
	}

}
