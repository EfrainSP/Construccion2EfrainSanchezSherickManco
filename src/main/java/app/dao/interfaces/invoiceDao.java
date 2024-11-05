package app.dao.interfaces;

import app.model.invoice;

public interface invoiceDao {
    public void createInvoice(invoice invoice) throws Exception;
}
