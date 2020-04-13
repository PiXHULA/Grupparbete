import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class UserModel implements Serializable {
    private String nameInput,pwInput,output;
    @OneToMany
    private List<User> userList = new ArrayList<>();

    public void populate() {
        userList.add(new User("Wilhelm","Hattenbach",3)); //Admin
        userList.add(new User("Cornelia", "Persson", 3)); //Admin
        userList.add(new User("Linus", "Svahn", 3)); //Admin
        userList.add(new User("Joakim", "Önnhage", 3)); //Admin
        userList.add(new User("Atef", "Sendesni", 3)); //Admin
        userList.add(new User("Kening", "Fohlin", 3)); //Admin / Overlord
        userList.add(new User("Victor", "Olofsson", 3)); //Admin
        userList.add(new User("Emmy", "De Stefano", 3)); //Admin
        userList.add(new User("Simon", "Wildbore", 3)); //Admin
        userList.add(new User("test","test")); //Vanlig kund
        userList.add(new User("test2","test2",2)); //Super kund
    }

    public String loginValidate(){
        populate();
        for(User user : userList){
            if(user.getName().equalsIgnoreCase(nameInput) &&
                user.getPassword().equals(pwInput)){
                return checkUserRole(user);
            }
        }
        return output = "Nånting";
    }
    //LUNCH NU 12:40

    private String checkUserRole(User user) {
        if (user.getUserRole() < 3){
            return "Customer";
        }else
            return "Admin";
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
}
