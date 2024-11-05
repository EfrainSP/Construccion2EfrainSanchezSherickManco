
package app.controller;

import java.sql.Date;
import app.Controllervalidator.PersonValidator;
import app.Controllervalidator.UserValidator;
import AppDto.PersonDto;
import AppDto.UserDto;
import app.service.interfaces.GuestService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@Getter
@Setter
@NoArgsConstructor

public class GuestController implements ControllerInterface {
    @Autowired
    private PersonValidator personavalidator;
    @Autowired
    private UserValidator UserValidator;
    @Autowired
    private GuestService service;
    
    private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1.Realizar Consumo \n 2. para cerrar sesion";
    
    
    
    
    public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = GuestSession();
		}

	}
    private boolean GuestSession() {
		try {
			System.out.println(MENU);
			String option = utils.getReader().nextLine();
			return menu(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
                        for(StackTraceElement es : e.getStackTrace()){
                            System.out.println(es.toString());
                        }
			return true;
		}
	}
    private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			this.createinvoice_guest();
			return true;
		}
		case "2": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
		default: {
			System.out.println("opcion invalida");
			return true;
		}
		}

	}
    private void createinvoice_guest() throws Exception{ 
        
            this.service.createinvoice_Guest();
            
    }

    
    
    
}
