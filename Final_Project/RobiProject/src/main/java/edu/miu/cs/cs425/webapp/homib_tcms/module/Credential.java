package edu.miu.cs.cs425.webapp.homib_tcms.module;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @Column(name = "credential_id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credentialId;
    @Column(name = "username",nullable=false)
    @NotBlank(message = "Please provide password")
    private String userName;
    @Column(name = "password",nullable=false)
    @NotBlank(message = "Please provide password")
    private String password;

    @OneToOne(mappedBy = "credential", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    public Credential(Long credentialId,
                      @NotBlank(message = "Please provide password") String userName,
                      @NotBlank(message = "Please provide password") String password) {
        this.credentialId = credentialId;
        this.userName = userName;
        this.password = password;
    }

    public Credential(@NotBlank(message = "Please provide password") String userName,
                      @NotBlank(message = "Please provide password") String password) {
        this.userName = userName;
        this.password = password;
    }

    public Credential() {
    }

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", edu.miu.cs.cs425.webapp.homib_tcms.module.Credential.class.getSimpleName() + "[", "]")
                .add("credentialId=" + credentialId)
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("user=" + user)
                .toString();
    }
}
