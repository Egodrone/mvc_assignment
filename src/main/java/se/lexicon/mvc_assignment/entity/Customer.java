package se.lexicon.mvc_assignment.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String customerId;
    @Column(nullable = false, length = 200)
    private String email;
    @Column(nullable = false, length = 100)
    private LocalDate regDate;
    @Column(nullable = false)
    private boolean active;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;

    public Customer() {
    }

    public Customer(String email, LocalDate regDate, boolean active, CustomerDetails customerDetails) {
        this.email = email;
        this.regDate = regDate;
        this.active = active;
        this.customerDetails = customerDetails;
    }

    public Customer(String customerId, String email, LocalDate regDate, boolean active, CustomerDetails customerDetails) {
        this.customerId = customerId;
        this.email = email;
        this.regDate = regDate;
        this.active = active;
        this.customerDetails = customerDetails;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active && Objects.equals(customerId, customer.customerId) && Objects.equals(email, customer.email) && Objects.equals(regDate, customer.regDate) && Objects.equals(customerDetails, customer.customerDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, regDate, active, customerDetails);
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", active=" + active +
                ", customerDetails=" + customerDetails +
                '}';
    }


}
