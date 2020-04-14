package Model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class AdminModel implements Serializable {

    UserModel userModel = new UserModel();
    List<User> userList = userModel.getUserList();
    private String userName;

    @PostConstruct
    public void init() {
        showCostumers();
    }


    public void showCostumers() {
        userList = userList.stream().filter(user -> user.getUserRole().getUserRoleEnum() < 3).collect(Collectors.toList());
    }

    public String goToCostumerProfile(String customerName) {
        this.userName = customerName;
        return "Costumer_Profile";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
