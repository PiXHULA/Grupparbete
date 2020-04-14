package Model;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pwValidator")
public class PwValidator implements Validator<String> {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String value) throws ValidatorException {
        char[] chars = value.toCharArray();
        boolean text = false;
        boolean numbers = false;

        for (char c : chars) {
            if (Character.isLetter(c)) {
                text = true;
            }
            if (Character.isDigit(c)) {
                numbers = true;
            }
        }

        if (!text || !numbers) {
            String messageText = "Both digits and letters needed";
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messageText, messageText));
        }
    }
}