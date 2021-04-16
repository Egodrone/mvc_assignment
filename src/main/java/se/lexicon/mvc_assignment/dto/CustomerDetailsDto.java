package se.lexicon.mvc_assignment.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class CustomerDetailsDto {
    private String detailsId;
    @NotNull(message = "Street can't be null")
    @NotEmpty(message = "Street should not be empty")
    @Size(min = 3, max = 30, message = "Street must be between 3 and 30 characters")
    private String street;
    @NotNull
    @NotEmpty(message = "Zip Code can't be empty")
    @Size(min = 3, max = 20, message = "Zip Code must be between 3 and 20 characters")
    private String zipCode;
    @NotNull
    @NotEmpty(message = "City should not be empty")
    @Size(min = 3, max = 20, message = "City must be between 3 and 20 characters")
    private String city;
    @NotNull
    @NotEmpty(message = "should not be empty")
    @Size(min = 6, max = 10, message = "Home Phone should be between 6 and 10 numbers")
    private String homePhone;
    @NotNull
    @NotEmpty(message = "Mobile phone should not be empty")
    @Size(min = 6, max = 10, message = "Mobile phone should be between 6 and 10 numbers")
    private String cellphone;

}
