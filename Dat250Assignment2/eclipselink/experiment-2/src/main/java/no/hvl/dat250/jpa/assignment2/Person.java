package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToMany
    private Collection<Address> addresses;
    @OneToMany
    private Collection<CreditCard> creditCards;

    public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public void setCreditCards(Collection<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}


	public Collection<Address> getAddresses() {
		return addresses;
	}

	public Collection<CreditCard> getCreditCards() {
		return creditCards;
	}

	
}
