package edu.miu.cs.cs425.webapp.homib_tcms.module;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;


    @Column(nullable=false)
    @NotBlank(message = "Please provide street number!")
    private String street;

    @Column(name = "city",nullable=false)
    @NotBlank(message = "Please provide city name!")
    private String city;

    @Column(name = "state",nullable=false)
    @NotBlank(message = "Please provide state name!")
    private String state;

    @Column(name = "zip_code",nullable=false)
    @Digits(fraction = 0,integer = 5,message = "Please provide valid zip code")
    private Integer zipCode;


    @Column(name = "country",nullable=false)
    @NotBlank(message = "Please provide country name!")
    private String country;

    //User
    @OneToOne(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    public Address(Long addressId,
                   @NotBlank(message = "Please provide street number!") String street,
                   @NotBlank(message = "Please provide city name!") String city,
                   @NotBlank(message = "Please provide state name!") String state,
                   @Digits(fraction = 0, integer = 5, message = "Please provide valid zip code") Integer zipCode,
                   @NotBlank(message = "Please provide country name!") String country) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Address(@NotBlank(message = "Please provide street number!") String street,
                   @NotBlank(message = "Please provide city name!") String city,
                   @NotBlank(message = "Please provide state name!") String state,
                   @Digits(fraction = 0, integer = 5, message = "Please provide valid zip code") Integer zipCode,
                   @NotBlank(message = "Please provide country name!") String country, User user) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.user = user;
    }

    public Address() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", edu.miu.cs.cs425.webapp.homib_tcms.module.Address.class.getSimpleName() + "[", "]")
                .add("addressId=" + addressId)
                .add("street='" + street + "'")
                .add("city='" + city + "'")
                .add("state='" + state + "'")
                .add("zipCode=" + zipCode)
                .add("country='" + country + "'")
                .add("user=" + user)
                .toString();
    }
}
