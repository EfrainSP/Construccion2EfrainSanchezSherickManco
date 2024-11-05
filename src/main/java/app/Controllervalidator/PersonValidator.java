
package app.Controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class PersonValidator extends CommonsValidator{
    
        public void validName(String name) throws Exception{
		super.isValidString("el nombre de la persona ", name);
	}
	
	public long validDocument(String cedula) throws Exception{
		return super.isValidLong("la cedula de la persona ", cedula);
	}
	
	public int validCellphone(String Celphone) throws Exception{
		return super.isValidInteger("El telefono de la persona ",Celphone);
	}
}
