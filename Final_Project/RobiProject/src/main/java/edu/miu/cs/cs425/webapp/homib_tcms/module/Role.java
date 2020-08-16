package edu.miu.cs.cs425.webapp.homib_tcms.module;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "roles")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "role_id")
    private Long roleId;
@Column(name = "role_name", nullable = false)
@NotBlank(message = "this field is required")
    private String roleName;

    //user
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(Long roleId, @NotBlank(message = "this field is required") String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Role(@NotBlank(message = "this field is required") String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", edu.miu.cs.cs425.webapp.homib_tcms.module.Role.class.getSimpleName() + "[", "]")
                .add("roleId=" + roleId)
                .add("roleName='" + roleName + "'")
                .add("users=" + users)
                .toString();
    }
}
