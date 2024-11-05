package app.helpers;

import AppDto.GuestDto;
import AppDto.PersonDto;
import AppDto.UserDto;
import app.model.Person;
import app.model.User;
import app.model.Partner;
import AppDto.PartnerDto;
import AppDto.invoiceDetailDto;
import AppDto.invoiceDto;
import app.model.Guest;
import app.model.invoice;
import app.model.InvoiceDetail;

public abstract class Helpers {

    public static PersonDto parse(Person person) {
        if (person == null) {
            return null;
        }

        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setCedula(person.getCedula());
        personDto.setName(person.getName());
        personDto.setCelphone(person.getCellphone());
        return personDto;
    }

    public static Person parse(PersonDto personDto) {
        if (personDto == null) {
            return null;
        }
        Person person = new Person();
        person.setId(personDto.getId());
        person.setCedula(personDto.getCedula());
        person.setName(personDto.getName());
        person.setCellphone(personDto.getCelphone());
        return person;
    }

    public static UserDto parse(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setPersonId(parse(user.getPersonId()));
        userDto.setId(user.getId());
        userDto.setRol(user.getRol());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static User parse(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setPersonId(parse(userDto.getPersonId()));
        user.setId(userDto.getId());
        user.setRol(userDto.getRol());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static PartnerDto parse(Partner Partner) {
        if (Partner == null) {
            return null;
        }
        PartnerDto PartnerDto = new PartnerDto();
        PartnerDto.setId(Partner.getId());
        PartnerDto.setMoney(Partner.getMoney());
        PartnerDto.setType(Partner.getType());
        PartnerDto.setDatecreated(Partner.getDatecreated());
        PartnerDto.setUserId(parse(Partner.getUserId()));
        return PartnerDto;

    }

    public static Partner parse(PartnerDto partnerDto) {
        if (partnerDto == null) {
            return null;
        }
        Partner partner = new Partner();
        partner.setId(partnerDto.getId());
        partner.setMoney(partnerDto.getMoney());
        partner.setType(partnerDto.getType());
        partner.setDatecreated(partnerDto.getDatecreated());
        partner.setUserId(parse(partnerDto.getUserId()));
        return partner;
    }

    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setPartner(parse(guest.getPartner()));
        guestDto.setStatus(guest.getStatus());
        guestDto.setUser(parse(guest.getUser()));

        return guestDto;
    }

    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setPartner(parse(guestDto.getPartner()));
        guest.setStatus(guestDto.getStatus());
        guest.setUser(parse(guestDto.getUser()));

        return guest;
    }
    public static invoiceDto Parse(invoice invoice){
        if (invoice == null) {
            return null;
        }
        invoiceDto invoiceDto = new invoiceDto();
        invoiceDto.setAmount(invoice.getAmount());
        invoiceDto.setDateCreate(invoice.getDateCreate());
        invoiceDto.setId(invoice.getId());
        invoiceDto.setPartner(parse(invoice.getPartnerId()));
        invoiceDto.setPerson(parse(invoice.getPersonId()));
        invoiceDto.setStatus(invoice.getStatus());
        return invoiceDto;
        
    }
    public static invoice Parse(invoiceDto invoiceDto){
         if (invoiceDto == null) {
            return null;
        }
        invoice invoice = new invoice();
        invoice.setAmount(invoiceDto.getAmount());
        invoice.setDateCreate(invoiceDto.getDateCreate());
        invoice.setId(invoiceDto.getId());
        invoice.setPartnerId(parse(invoiceDto.getPartner()));
        invoice.setPersonId(parse(invoiceDto.getPerson()));
        invoice.setStatus(invoiceDto.getStatus());
        
        return invoice;
    }
    
    public static invoiceDetailDto Parse(InvoiceDetail invoiceDetail){
        if (invoiceDetail == null) {
            return null;
        }
        invoiceDetailDto invoicedetaildto= new invoiceDetailDto ();
        invoicedetaildto.setAmount(invoiceDetail.getAmount());
        invoicedetaildto.setDescription(invoiceDetail.getDescription());
        invoicedetaildto.setId(invoiceDetail.getId());
        invoicedetaildto.setInvoice(Parse(invoiceDetail.getInvoiceid()));
        invoicedetaildto.setItem(invoiceDetail.getItem());
        return invoicedetaildto;
        
    }
    public static InvoiceDetail parse(invoiceDetailDto invoiceDetailDto){
        if (invoiceDetailDto == null) {
            return null;
        }
        InvoiceDetail invoiceDetail = new InvoiceDetail ();
        invoiceDetail.setAmount(invoiceDetailDto.getAmount());
        invoiceDetail.setDescription(invoiceDetailDto.getDescription());
        invoiceDetail.setId(invoiceDetailDto.getId());
        invoiceDetail.setInvoiceid(Parse(invoiceDetailDto.getInvoice()));
        invoiceDetail.setItem(invoiceDetailDto.getItem());
        return invoiceDetail;
    }

}
