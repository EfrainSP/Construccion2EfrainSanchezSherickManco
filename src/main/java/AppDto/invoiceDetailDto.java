
package AppDto;

public class invoiceDetailDto {
    private long id;
    private invoiceDto invoice;
    private int item;
    private String description;
    private double amount;

    public invoiceDetailDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public invoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(invoiceDto invoice) {
        this.invoice = invoice;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
