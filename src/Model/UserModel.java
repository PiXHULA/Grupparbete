package Model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class UserModel implements Serializable {

    private String nameInput, pwInput, output, errorMessage;
    @OneToMany
    private List<User> userList = new ArrayList<>();

    private User currentUser;

    @PostConstruct
    public void init() {  // körs bara en gång när sidan laddas
        populate();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void populate() {
        userList.add(new User("Wilhelm", "Hattenbach", UserRoles.ADMIN)); //Admin
        userList.add(new User("Cornelia", "Persson", UserRoles.ADMIN)); //Admin
        userList.add(new User("Linus", "Svahn", UserRoles.ADMIN)); //Admin
        userList.add(new User("Joakim", "Önnhage", UserRoles.ADMIN)); //Admin
        userList.add(new User("Atef", "Sendesni", UserRoles.ADMIN)); //Admin
        userList.add(new User("Kening", "Fohlin", UserRoles.ADMIN)); //Admin / Overlord
        userList.add(new User("Victor", "Olofsson", UserRoles.ADMIN)); //Admin
        userList.add(new User("Emmy", "De Stefano", UserRoles.ADMIN)); //Admin
        userList.add(new User("Simon", "Wildbore", UserRoles.ADMIN)); //Admin
        userList.add(new User("test", "test")); //Vanlig kund
        userList.add(new User("test2", "test2", UserRoles.SUPER_CUSTOMER)); //Super kund
        userList.add(new User("KUNDENS", "test")); //Vanlig kund
    }

    public String createUser() {
        userList.add(new User(nameInput, pwInput));
        return "index";
    }

    public String loginValidate() {
        // populate();
        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(nameInput) &&
                    user.getPassword().equals(pwInput)) {
                this.currentUser = user;
                return checkUserRole(user);
            }
        }
        output = null;
        sendErrorMsg();
        return output;
    }

    private void sendErrorMsg() {
        errorMessage = "Wrong username or password, try again";
    }

    private String checkUserRole(User user) {
        if (user.getUserRole().equals(UserRoles.NORMAL_CUSTOMER) || user.getUserRole().equals(UserRoles.SUPER_CUSTOMER)) {
            return "Customer";
        } else
            return "Admin";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getPwInput() {
        return pwInput;
    }

    public void setPwInput(String pwInput) {
        this.pwInput = pwInput;
    }

    public List<User> getUserList() {
         populate(); //Remove when connected to database
        return userList;
    }
}
