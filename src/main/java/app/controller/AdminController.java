package app.controller;

import app.Controllervalidator.PersonValidator;
import app.Controllervalidator.UserValidator;
import AppDto.PersonDto;
import AppDto.UserDto;
import AppDto.PartnerDto;
import app.controller.request.CreateUserRequest;
import app.service.ClubService;
import app.service.interfaces.AdminService;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@NoArgsConstructor
public class AdminController implements ControllerInterface {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidador;
    @Autowired
    private AdminService service;
    
    public void session() throws Exception {
        
    }
    
    @PostMapping("/partner")
    private ResponseEntity createPartner(@RequestBody CreateUserRequest request) throws Exception {
       try{ 
        String name=request.getName();
        personValidator.validName(name);
        long document=request.getDocument();
        long Cellphone = request.getCellphone();
        String userName = request.getUsername();
        userValidador.validUserName(userName);
        String password = request.getPassword();
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setCedula(document);
        personDto.setCelphone(Cellphone);
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUsername(userName);
        userDto.setPassword(password);
        userDto.setRol("Partner");
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setUserId(userDto);
        partnerDto.setDatecreated(new Timestamp(System.currentTimeMillis()));
        partnerDto.setMoney(50000);
        partnerDto.setType("regular");
        partnerDto.setUserId(userDto);

        this.service.createPartner(partnerDto);
                   return new ResponseEntity<>("el usuario se ha creado exitosamente",HttpStatus.OK);

       }catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
    
    @GetMapping("/")
    public String vive(){
        return "vive";
    }
    
}
