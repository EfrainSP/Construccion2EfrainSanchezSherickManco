package app.controller.request;

import app.model.Partner;
import app.model.Person;
import app.model.invoice;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sherick
 */
@Getter
@Setter
@NoArgsConstructor
public class CreateInvoiceRequest {
    private long PersonId;
    private long partnerId;
    private double amount;
    private String status;
    private invoice invoiceid;
    private int item;
    private String description;
    private double amountt;
}
