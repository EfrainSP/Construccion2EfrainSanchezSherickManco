
package AppDto;
import java.sql.Date;
import java.sql.Timestamp;

public class invoiceDto {
    private long id;
    private PersonDto person;
    private PartnerDto partner;
     private Timestamp dateCreate;
    private double amount;
    private String Status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public PartnerDto getPartner() {
        return partner;
    }

    public void setPartner(PartnerDto partner) {
        this.partner = partner;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

   

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

  
    public invoiceDto() {
    }

}
