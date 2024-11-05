package app.Controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class UserValidator extends CommonsValidator{
    
    public void validUserName(String userName) throws Exception {
		super.isValidString("el nombre de usuario ", userName);
	}
	public void validRole(String role) throws Exception {
		super.isValidString("el rol de usuario ", role);
	}
        public void validPassword(String password) throws Exception{
            super.isValidString("La constraseña", password);
        }
    
}