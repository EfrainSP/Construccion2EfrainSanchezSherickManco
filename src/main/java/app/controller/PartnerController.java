
package app.controller;

import AppDto.GuestDto;
import java.sql.Date;
import app.Controllervalidator.PersonValidator;
import app.Controllervalidator.UserValidator;
import AppDto.PersonDto;
import AppDto.UserDto;
import app.service.ClubService;
import app.service.interfaces.PartnerService;
import AppDto.PartnerDto;
import app.dao.interfaces.PartnerDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import AppDto.PartnerDto;
import AppDto.invoiceDetailDto;
import AppDto.invoiceDto;
import app.controller.request.ChangeStatusRequest;
import app.controller.request.CreateInvoiceRequest;
import app.controller.request.CreateUserRequest;
import app.controller.request.addFundsRequest;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.UserDao;
import app.dao.interfaces.invoiceDao;
import app.dao.interfaces.invoiceDetailDao;
import app.helpers.Helpers;
import app.model.InvoiceDetail;
import app.model.invoice;
import app.service.ClubService;
import static app.service.ClubService.addfunds;
import static app.service.ClubService.user;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
@Getter
@Setter
@NoArgsConstructor
public class PartnerController implements ControllerInterface{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidador;
    @Autowired
    private PartnerService service;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private UserDao userdao;
    @Autowired 
    private PersonDao persondao;
    @Autowired
    private invoiceDao invoicedao;
    @Autowired
    private invoiceDetailDao invoicedetaildao;

    private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1..Crear invitado\n 2. para cerrar sesion \n 3.Activar invitado \n 4.Desactivar invitado \n 5.Agregar Fondos  \n 6.Realizar Consumo ";
    
    
    public void session() throws Exception {
	}

     @PostMapping("/Guest")
         private ResponseEntity createGuest(@RequestBody CreateUserRequest request) throws Exception{
             try{
                 String name = request.getName();
                 personValidator.validName(name);
                 long document = (request.getDocument());
                 long Cellphone =request.getCellphone();
                 String userName = request.getUsername();
                 userValidador.validUserName(userName);
                 String password = request.getPassword();
                 userValidador.validPassword(password);
                 
                 PersonDto personDto = new PersonDto();
                 personDto.setName(name);
                 personDto.setCedula(document);
                 personDto.setCelphone(Cellphone);
                 UserDto userDto = new UserDto();
                 userDto.setUsername(userName);
                 userDto.setPassword(password);
                 userDto.setPersonId(personDto);
                 userDto.setRol("Guest");
                 GuestDto guestDto = new GuestDto();
                 PartnerDto partnerDto = new PartnerDto();
                 partnerDto.setId(request.getPartnerid());
                 this.partnerDao.findByid(partnerDto);
                      
                 guestDto.setPartner(partnerDto);
                 guestDto.setUser(userDto);
                 guestDto.setStatus("inactivo");
                 this.service.createGuest(guestDto);
                 System.out.println("se ha creado el Invitado exitosamente");
                 return new ResponseEntity<>("el usuario se ha creado exitosamente",HttpStatus.OK);
                 
             }catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
	}
     

   @PostMapping("/activateGuest")       
   private ResponseEntity activateGuest(@RequestBody ChangeStatusRequest request) throws Exception{
    
        try{ 
            long id = request.getGuestId();
         GuestDto guestDto = service.getGuestById(id);
         guestDto.setStatus("Activo");
         
         service.updateGuestStatus(guestDto);
          return new ResponseEntity<>("el usuario se ha activado exitosamente",HttpStatus.OK);
        }
         catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    
    }
   @PostMapping("/desactivateGuest")      
   
    private ResponseEntity desactivateGuest(@RequestBody ChangeStatusRequest request) throws Exception{
       try{ 
        long id= request.getGuestId();
        GuestDto guestdto = service.getGuestById(id);
        guestdto.setStatus("Inactivo");
        service.updateGuestStatus(guestdto);

        return new ResponseEntity<>("el usuario se ha desaactivado exitosamente",HttpStatus.OK);
       }
        catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
        
    }
    
    
    
   @PostMapping("/addfunds")
    private ResponseEntity addfunds(@RequestBody addFundsRequest request) throws Exception{
            try{
                
        PartnerDto partner = new PartnerDto();
        partner.setId(request.getPartnerId());
        PartnerDto partnerdto=partnerDao.findByid(partner);
        double monto = request.getAmount();
        partner.setId(request.getPartnerId());
        monto = partner.getMoney() + monto;
        UserDto user = new UserDto ();
        user.setUsername(request.getUsername());
        UserDto userdto = new UserDto();
        userdto=userdao.findByUsername(user);
        partner.setUserId(userdto);
        addfunds = monto;
        addfunds=monto+addfunds;
        if (partnerdto.getType().equals("regular") && addfunds >= 1000000) {
            System.out.println("No puedes tener mas de 1000000");
            addfunds = addfunds - monto;
        } else if (partnerdto.getType().equals("vip") && addfunds >= 5000000) {
            System.out.println("No puedes tener mas de 5000000");
        }
        partnerdto.setMoney(addfunds);
        this.partnerDao.getMoneyByPartner(addfunds);
        this.partnerDao.addfunds(partnerdto);
          return new ResponseEntity<>("el usuario se han agregado fondos  exitosamente",HttpStatus.OK);
       }
        catch(Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
   }
   
   
   
   
   
   
   
   
   
public void createinvoice() throws Exception {
        double monto = 0;
        String descripcion;
        UserDto userDto = ClubService.user;
        System.out.println(userDto.toString());
        PartnerDto partner = partnerDao.findByUserId(userDto);
        PersonDto person = persondao.findByCedula(userDto.getPersonId());
        System.out.println("Bienvenido " + partner.getUserId().getUsername() + " ingresa la cantidad de items a consumir");
        int items = utils.getReader().nextInt();
        List<invoiceDetailDto> invoices = new ArrayList<invoiceDetailDto>();
        invoiceDto invoiceDto = new invoiceDto();
        invoiceDto.setPartner(partner);
        invoiceDto.setPerson(person);
        invoiceDto.setStatus("Pago pendiente");
        invoiceDto.setDateCreate(new Timestamp(System.currentTimeMillis()));
        for (int i = 0; i < items; i++) {
            invoiceDetailDto invoicedetail = new invoiceDetailDto();
            invoicedetail.setInvoice(invoiceDto);
            invoicedetail.setItem(i + 1);
            System.out.println("Ingrese el monto del item " + invoicedetail.getItem());
            invoicedetail.setAmount(utils.getReader().nextDouble());
            System.out.println("Ingrese la descripcion del item " + invoicedetail.getItem());
            invoicedetail.setDescription("item: " + (i + 1) + " " + utils.getReader().next());
            monto = monto + invoicedetail.getAmount();
            invoices.add(invoicedetail);
        }
        invoiceDto.setAmount(monto);
        invoice invoice = Helpers.Parse(invoiceDto);
        invoicedao.createInvoice(invoice);

        for (invoiceDetailDto detail : invoices) {
            detail.setInvoice(invoiceDto);
            InvoiceDetail invoiceDetail = Helpers.parse(detail);
            invoiceDetail.setInvoiceid(invoice);
            invoicedetaildao.createInvoiceDetail(invoiceDetail);
        }
        System.out.println("Factura creada");

    }
}
      

