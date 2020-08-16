package edu.miu.cs.cs425.webapp.homib_tcms.module;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long bookingId;
    @Column(name = "load_number", nullable = false, unique = true)
    @NotBlank(message = "You must provide Load Number")
    private String loadNumber;
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "Please Provide First Name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Please Provide Last Name")
    private String lastName;
    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "Please Provide Phone Number")
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    @NotBlank(message = "Please Provide Email Address")
    private String email;

    public edu.miu.cs.cs425.webapp.homib_tcms.module.User getUser() {
        return user;
    }

    public void setUser(edu.miu.cs.cs425.webapp.homib_tcms.module.User user) {
        this.user = user;
    }

    //User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotBlank(message = "Please Provide User Id")
    private User user;

    //Load
    @ManyToOne
    @JoinColumn(name = "load_bookingid", nullable = false, unique = true)
    @NotBlank(message = "Please Provide Load Id")
    private Load load;

    public Booking(Long bookingId,
                   @NotBlank(message = "You must provide Load Number") String loadNumber,
                   @NotBlank(message = "Please Provide First Name") String firstName,
                   @NotBlank(message = "Please Provide Last Name") String lastName,
                   @NotBlank(message = "Please Provide Phone Number") String phoneNumber,
                   @NotBlank(message = "Please Provide Email Address") String email,
                   @NotBlank(message = "Please Provide User Id")User user,
                   @NotBlank(message = "Please Provide Load Id") Load load) {
        this.bookingId = bookingId;
        this.loadNumber = loadNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
        this.load = load;
    }

    public Booking() {
    }

    public Booking(@NotBlank(message = "You must provide Load Number") String loadNumber,
                   @NotBlank(message = "Please Provide First Name") String firstName,
                   @NotBlank(message = "Please Provide Last Name") String lastName,
                   @NotBlank(message = "Please Provide Phone Number") String phoneNumber,
                   @NotBlank(message = "Please Provide Email Address") String email) {
        this.loadNumber = loadNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getLoadNumber() {
        return loadNumber;
    }

    public void setLoadNumber(String loadNumber) {
        this.loadNumber = loadNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(edu.miu.cs.cs425.webapp.homib_tcms.module.Load load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", edu.miu.cs.cs425.webapp.homib_tcms.module.Booking.class.getSimpleName() + "[", "]")
                .add("bookingId=" + bookingId)
                .add("loadNumber='" + loadNumber + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("email='" + email + "'")
                .add("user=" + user)
                .add("load=" + load)
                .toString();
    }
}
