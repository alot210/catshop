package presentation;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("loginValidator")
public class LoginValidator implements Validator {


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        //Valdierungscode: passwort muss ziffer beinhalten

        //convertierung
        String pw = (String) value;
        System.out.println("pw:" + pw);

        String regEx = ".*[0-9].*]";

        if(!pw.matches(regEx)){
            throw new ValidatorException(new FacesMessage("Passwort entspricht nicht den vorgaben.Muss mindestens eine Ziffer enhalten."));
        }

    }
}
