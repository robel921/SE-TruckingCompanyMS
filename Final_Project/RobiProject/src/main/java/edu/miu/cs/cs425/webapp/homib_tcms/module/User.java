package edu.miu.cs.cs425.webapp.homib_tcms.module;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long userId;
    @Column(name = "license_number", nullable = false, unique = true)
    @NotBlank(message = "*This field is required")
    private String licenseNumber;
    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "*This field is required")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "*This field is required")
    private String lastName;
    @Column(name = "dateof_birth", nullable = false)
    @NotBlank(message = "*This field is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateofbirth;
    @Column(name = "hire_date", nullable = false)
    @NotBlank(message = "*This field is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hiredate;
    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "*This field is required")
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    @NotBlank(message = "*This field is required")
    private String email;

    //Booking
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Booking> booking;

    //Role
    @ManyToMany
    @JoinTable(
            name="user_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
    private List<Role> roles;

    //Credential
    @OneToOne
    @JoinColumn(name="credential_id", nullable = true, unique = true)
    private Credential credential;

    //Address
    @OneToOne
    @JoinColumn(name = "user_address", nullable = true, unique = true)
    private Address address;


    public User(Long userId,
                @NotBlank(message = "*This field is required") String licenseNumber,
                @NotBlank(message = "*This field is required") String firstName, String middleName,
                @NotBlank(message = "*This field is required") String lastName,
                @NotBlank(message = "*This field is required") LocalDate dateofbirth,
                @NotBlank(message = "*This field is required") LocalDate hiredate,
                @NotBlank(message = "*This field is required") String phoneNumber,
                @NotBlank(message = "*This field is required") String email, Address address) {
        this.userId = userId;
        this.licenseNumber = licenseNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateofbirth = dateofbirth;
        this.hiredate = hiredate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(@NotBlank(message = "*This field is required") String licenseNumber,
                @NotBlank(message = "*This field is required") String firstName, String middleName,
                @NotBlank(message = "*This field is required") String lastName,
                @NotBlank(message = "*This field is required") LocalDate dateofbirth,
                @NotBlank(message = "*This field is required") LocalDate hiredate,
                @NotBlank(message = "*This field is required") String phoneNumber,
                @NotBlank(message = "*This field is required") String email, List<edu.miu.cs.cs425.webapp.homib_tcms.module.Role> roles, edu.miu.cs.cs425.webapp.homib_tcms.module.Credential credential) {
        this.licenseNumber = licenseNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateofbirth = dateofbirth;
        this.hiredate = hiredate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.roles = roles;
        this.credential = credential;
    }

    public User() {
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public List<edu.miu.cs.cs425.webapp.homib_tcms.module.Role> getRoles() {
        return roles;
    }

    public void setRoles(List<edu.miu.cs.cs425.webapp.homib_tcms.module.Role> roles) {
        this.roles = roles;
    }

    public edu.miu.cs.cs425.webapp.homib_tcms.module.Credential getCredential() {
        return credential;
    }

    public void setCredential(edu.miu.cs.cs425.webapp.homib_tcms.module.Credential credential) {
        this.credential = credential;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", edu.miu.cs.cs425.webapp.homib_tcms.module.User.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("licenseNumber='" + licenseNumber + "'")
                .add("firstName='" + firstName + "'")
                .add("middleName='" + middleName + "'")
                .add("lastName='" + lastName + "'")
                .add("dateofbirth=" + dateofbirth)
                .add("hiredate=" + hiredate)
                .add("phoneNumber='" + phoneNumber + "'")
                .add("email='" + email + "'")
                .add("booking=" + booking)
                .add("roles=" + roles)
                .add("credential=" + credential)
                .add("address=" + address)
                .toString();
    }
}
