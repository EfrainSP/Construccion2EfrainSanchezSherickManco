package app.service;

import java.sql.Date;
import java.sql.SQLException;

import app.dao.Persondaoimplementation;
import app.dao.UserDaoImplementation;
import app.dao.Partnerdaoimplemention;
import AppDto.PartnerDto;
import app.dao.interfaces.UserDao;
import app.dao.interfaces.GuestDao;
import app.dao.interfaces.PartnerDao;
import app.dao.interfaces.PersonDao;
import app.dao.interfaces.invoiceDao;
import AppDto.GuestDto;
import AppDto.PersonDto;
import AppDto.UserDto;
import AppDto.PartnerDto;
import AppDto.invoiceDetailDto;
import AppDto.invoiceDto;
import app.controller.request.CreateInvoiceRequest;
import app.controller.request.CreateUserRequest;
import app.controller.utils;
import app.dao.Guestdaoimplementation;
import app.dao.interfaces.invoiceDetailDao;
import app.helpers.Helpers;
import app.model.InvoiceDetail;
import app.model.invoice;
import app.service.interfaces.AdminService;
import app.service.interfaces.GuestService;
import app.service.interfaces.LoginService;
import app.service.interfaces.PartnerService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Getter
@Setter
@NoArgsConstructor
public class ClubService implements LoginService, AdminService, PartnerService, GuestService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private GuestDao guestdao;
    @Autowired
    private PartnerDao partnerdao;
    @Autowired
    private PersonDao persondao;
    @Autowired
    private invoiceDao invoicedao;
    @Autowired
    private invoiceDetailDao invoicedetaildao;
    @Autowired
    public static UserDto user;

    public static double addfunds;

    public void login(UserDto userDto) throws Exception {
        UserDto validateDto = userDao.findByUsername(userDto);
        if (validateDto == null) {
            throw new Exception("no existe usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            System.out.println(validateDto.getPassword());
            System.out.println(userDto.getPassword());
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRol(validateDto.getRol());
        user = validateDto;

    }

    public void logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    private void createPerson(PersonDto personDto) throws Exception {
        if (this.persondao.existsByCedula(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
        }
        this.persondao.createPerson(personDto);
    }

    private void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        if (this.userDao.existsByUsername(userDto)) {
            this.persondao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try {
            this.userDao.createUser(userDto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.persondao.deletePerson(userDto.getPersonId());
        }
    }

    @Override
    public void createPartner(PartnerDto partnerDto) throws Exception {
        this.createUser(partnerDto.getUserId());
        UserDto userDto = userDao.findByUsername(partnerDto.getUserId());
        partnerDto.setUserId(userDto);
        this.partnerdao.createPartner(partnerDto);

    }

    @Override
    public void createGuest(GuestDto GuestDto) throws Exception {
        this.createUser(GuestDto.getUser());
        guestdao.createGuest(GuestDto);

    }

    public GuestDto getGuestById(long guestId) throws Exception {
        return guestdao.getGuestById(guestId);
    }

    public void updateGuestStatus(GuestDto guestDto) throws Exception {
        guestdao.ActivateStatus(guestDto);
    }

    public void addfunds() throws Exception {
        
    }


    @Override
    public void createinvoice_Guest() throws Exception {
        double monto = 0;
        String descripcion;
        UserDto userDto = ClubService.user;
        System.out.println(userDto.toString());

        GuestDto guestdto = guestdao.findByUserId(userDto);
        // PartnerDto partner = partnerdao.findByUserId(userDto);
        PersonDto person = persondao.findByCedula(userDto.getPersonId());
        System.out.println("Bienvenido " + guestdto.getUser().getUsername() + " ingresa la cantidad de items a consumir");
        int items = utils.getReader().nextInt();
        List<invoiceDetailDto> invoices = new ArrayList<invoiceDetailDto>();
        invoiceDto invoiceDto = new invoiceDto();
        invoiceDto.setPartner(guestdto.getPartner());
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

    @Override
    public void createinvoice() throws Exception {
    
    }

}
