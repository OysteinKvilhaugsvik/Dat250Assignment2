package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private int count;
    
    public Long getId() {
        return id;
    }

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPincode() {
		return pincode;
	}

	public int getCount() {
		return count;
	}

   
}
