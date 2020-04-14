package Model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@SessionScoped
public class UserModel implements Serializable {
    private String nameInput, pwInput, output, errorMessage;
    private MockDatabase database;
    private User currentUser;

    @PostConstruct
    public void init() {  // körs bara en gång när sidan laddas
        database = MockDatabase.getSingleton();
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public String createUser() {
        database.addUser(new User(nameInput, pwInput));
        return "index";
    }

    public String loginValidate() {
        for (User user : getUserList()) {
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
        return (user.isAdmin()) ? "admin" : "customer";
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

    public Collection<User> getUserList() {
        return database.getAllUsers();
    }
}
