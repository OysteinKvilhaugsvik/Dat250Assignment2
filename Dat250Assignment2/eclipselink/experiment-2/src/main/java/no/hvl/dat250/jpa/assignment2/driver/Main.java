package no.hvl.dat250.jpa.assignment2.driver;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.dat250.jpa.assignment2.Address;
import no.hvl.dat250.jpa.assignment2.Bank;
import no.hvl.dat250.jpa.assignment2.CreditCard;
import no.hvl.dat250.jpa.assignment2.Person;
import no.hvl.dat250.jpa.assignment2.Pincode;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Person person = new Person();
        person.setName("Max Mustermann");
        Set<Person> owners = new HashSet<>();
        owners.add(person);

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        address.setOwners(owners);
        
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        person.setAddresses(addresses);
        
        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);
        
        Bank bank = new Bank();
        bank.setName("Pengebank");
        
        CreditCard creditCard1 = new CreditCard();
        creditCard1.setPincode(pincode);
        creditCard1.setNumber(12345);
        creditCard1.setBalance(-5000);
        creditCard1.setLimit(-10000);
        creditCard1.setOwningBank(bank);
        CreditCard creditCard2 = new CreditCard();
        creditCard2.setPincode(pincode);
        creditCard2.setNumber(123);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);
        creditCard2.setOwningBank(bank);
        
        Set<CreditCard> ownedCards = new HashSet<>();
        ownedCards.add(creditCard1);
        ownedCards.add(creditCard2);
        
        bank.setOwnedCards(ownedCards);
        person.setCreditCards(ownedCards);
        
        em.persist(person);
        em.persist(address);
        em.persist(pincode);
        em.persist(creditCard1);
        em.persist(creditCard2);
        em.persist(bank);
        em.getTransaction().commit();
        em.close();
    }
}
