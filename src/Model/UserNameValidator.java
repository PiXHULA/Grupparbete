package Model;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidator")
public class UserNameValidator implements Validator<String> {
    private MockDatabase database = MockDatabase.getInstance();

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String value) throws ValidatorException {
        boolean uniqueUsername = true;

        for (User user : database.getAllUsers()) {
            if (user.getName().equalsIgnoreCase(value)) {
                uniqueUsername = false;
                break;
            }
        }

        if (!uniqueUsername) {
            String messageText = "The username you want is already taken";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messageText, messageText));
        }
    }
}
