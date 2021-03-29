package se.lexicon.mvc_assignment.dto;


import java.util.Objects;
import java.util.UUID;


public class CustomerDetailsDto {
    private UUID detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellphone;


    public CustomerDetailsDto() {
    }

    public CustomerDetailsDto(UUID detailsId, String street, String zipCode, String city, String homePhone, String cellphone) {
        this.detailsId = detailsId;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.homePhone = homePhone;
        this.cellphone = cellphone;
    }

    public UUID getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(UUID detailsId) {
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
