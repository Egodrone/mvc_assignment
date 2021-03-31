package se.lexicon.mvc_assignment.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


public class CustomerDto {
    private UUID customerId;
    @NotEmpty(message = "Field cannot be empty")
    @Size(min = 6,max = 35, message = "Has to be in 6-35 characters range")
    private String email;
    private LocalDate regDate;
    private boolean active;
    private CustomerDetailsDto customerDetailsDto;

    public CustomerDto() {
    }

    public CustomerDto(UUID customerId, String email, LocalDate regDate, boolean active, CustomerDetailsDto customerDetailsDto) {
        this.customerId = customerId;
        this.email = email;
        this.regDate = regDate;
        this.active = active;
        this.customerDetailsDto = customerDetailsDto;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
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

    public CustomerDetailsDto getCustomerDetailsDto() {
        return customerDetailsDto;
    }

    public void setCustomerDetailsDto(CustomerDetailsDto customerDetailsDto) {
        this.customerDetailsDto = customerDetailsDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return active == that.active && Objects.equals(customerId, that.customerId) && Objects.equals(email, that.email) && Objects.equals(regDate, that.regDate) && Objects.equals(customerDetailsDto, that.customerDetailsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, regDate, active, customerDetailsDto);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", active=" + active +
                ", customerDetailsDto=" + customerDetailsDto +
                '}';
    }

}
