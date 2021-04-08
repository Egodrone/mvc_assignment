package se.lexicon.mvc_assignment.dto;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


public class CustomerDetailsDto {
    private String detailsId;
    @NotNull(message = "Street can't be null")
    @NotEmpty(message = "Street should not be empty")
    @Size(min = 3, max = 30, message = "Street must be between 3 and 30 characters")
    private String street;
    @NotEmpty(message = "Zip Code can't be null")
    @Size(min = 3, max = 20, message = "Zip Code must be between 3 and 20 characters")
    private String zipCode;
    @NotEmpty(message = "City should not be empty")
    @Size(min = 3, max = 20, message = "City must be between 3 and 20 characters")
    private String city;
    @NotEmpty(message = "should not be empty")
    @Size(min = 6, max = 10, message = "Home Phone should be between 6 and 10 numbers")
    private String homePhone;
    @NotEmpty(message = "Mobile phone should not be empty")
    @Size(min = 6, max = 10, message = "Mobile phone should be between 6 and 10 numbers")
    private String cellphone;


    public CustomerDetailsDto() {
    }

    public CustomerDetailsDto(String detailsId, String street, String zipCode, String city, String homePhone, String cellphone) {
        this.detailsId = detailsId;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.homePhone = homePhone;
        this.cellphone = cellphone;
    }

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetailsDto that = (CustomerDetailsDto) o;
        return Objects.equals(detailsId, that.detailsId) && Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(homePhone, that.homePhone) && Objects.equals(cellphone, that.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, street, zipCode, city, homePhone, cellphone);
    }

    @Override
    public String toString() {
        return "CustomerDetailsDto{" +
                "detailsId=" + detailsId +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }

}
