package se.lexicon.mvc_assignment.dto;


import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
public class CustomerDto {
    private String customerId;
    @NotNull
    @NotEmpty(message = "Field cannot be empty")
    @Size(min = 6,max = 35, message = "Has to be in 6-35 characters range")
    @Email(message = "Need to be an email address")
    private String email;
    private LocalDate regDate;
    private boolean active;
    @Valid
    private CustomerDetailsDto customerDetailsDto;
    
}
