
package app.controller;

import app.service.ClubService;
import java.util.HashMap;
import java.util.Map;

import app.Controllervalidator.UserValidator;
import AppDto.UserDto;
import app.service.ClubService;
import app.service.interfaces.LoginService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
@Controller
@Getter
@Setter
public class LoginController implements ControllerInterface{
        @Autowired
        private UserValidator userValidator;
        @Autowired
 	private LoginService service;
	private static final String MENU= "ingrese la opcion que desea: \n 1. para iniciar sesion. \n 2. para detener la ejecucion.";
	private Map<String,ControllerInterface> roles;
	public LoginController(AdminController AdminController,PartnerController PartnerController,GuestController GuestController) {
                this.roles= new HashMap<String,ControllerInterface>();
		roles.put("admin", AdminController);
		roles.put("Partner",PartnerController );
		roles.put("Guest",GuestController);
                
	}
    @Override
	public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = menu();
		}		
	}
	
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	private boolean options(String option) throws Exception {
		switch (option) {
		case "1": {
			this.login();
			return true;
		}
		case "2": {
			System.out.println("se detiene el programa");;
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}
	
	private void login()throws Exception {
		System.out.println("ingrese el usuario");
		String userName= utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("ingrese la contraseña");
		String password= utils.getReader().nextLine();
		userValidator.validPassword(password);
		UserDto userDto = new UserDto();
		userDto.setPassword(password);
		userDto.setUsername(userName);
		this.service.login(userDto);
		if(roles.get(userDto.getRol())==null) {
			throw new Exception ("Rol invalido");
		}
		roles.get(userDto.getRol()).session();
		
	}
	
	
}
