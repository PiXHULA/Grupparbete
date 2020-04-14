package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private UserRoles userRole;
    private String userRoleName;

    @OneToMany
    private List<Purchase> purchaseList;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.userRole = UserRoles.NORMAL_CUSTOMER;
    }

    public User(String name, String password, UserRoles userRole) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }

    public String getUserRoleName(){
        userRoleName = this.userRole.getRoleNameEnum();
        return userRoleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoles userRole) {
        this.userRole = userRole;
    }

}