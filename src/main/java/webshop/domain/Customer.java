package webshop.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;

//    public Customer(){}

    public Customer(String customerId, String firstName, String lastName, Contact contact, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }
}
