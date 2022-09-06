package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int balance;
    private int limit;
    @OneToOne
    private Pincode pinCode;
    @ManyToOne
    private Bank owningBank;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pincode getPincode() {
		return pinCode;
	}

	public void setPincode(Pincode pinCode) {
		this.pinCode = pinCode;
	}

	public Bank getOwningBank() {
		return owningBank;
	}

	public void setOwningBank(Bank owingBank) {
		this.owningBank = owingBank;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
