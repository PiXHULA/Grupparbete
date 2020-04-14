import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.List;

@FacesValidator("usernameValidator")
public class UserNameValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        String userInput = (String) value;
        UserModel userModel = new UserModel();
        boolean isUsernameUnique = true;

        List<User> userList = userModel.getUserList(); //Lista att kolla mot användare
        for(User user : userList){
            if(user.getName().equalsIgnoreCase(userInput)){
                isUsernameUnique = false;
                break;
            }
        }
            if (!isUsernameUnique) {
                String messageText = "The username you want to take is already taken";
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messageText, messageText));
            }
    }
}
