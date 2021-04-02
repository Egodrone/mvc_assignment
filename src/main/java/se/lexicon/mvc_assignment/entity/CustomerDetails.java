package se.lexicon.mvc_assignment.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String detailsId;

    @Column(nullable = false, length = 30)
    private String street;
    @Column(nullable = false, length = 20)
    private String zipCode;
    @Column(nullable = false, length = 20)
    private String city;
    @Column(nullable = false, length = 10)
    private String homePhone;
    @Column(nullable = false, length = 10)
    private String cellphone;

    public CustomerDetails() {
    }

    public CustomerDetails(String street, String zipCode, String city, String homePhone, String cellphone) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.homePhone = homePhone;
        this.cellphone = cellphone;
    }

    public CustomerDetails(String detailsId, String street, String zipCode, String city, String homePhone, String cellphone) {
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
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(detailsId, that.detailsId) && Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(homePhone, that.homePhone) && Objects.equals(cellphone, that.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, street, zipCode, city, homePhone, cellphone);
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "detailsId='" + detailsId + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }


}
