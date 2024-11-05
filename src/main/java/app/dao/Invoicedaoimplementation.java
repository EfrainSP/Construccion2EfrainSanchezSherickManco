/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfaces.invoiceDao;
import app.dao.repositories.InvoiceRepository;
import app.model.invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sherick
 */
@Service
@NoArgsConstructor
@Getter
@Setter
public class Invoicedaoimplementation implements invoiceDao{
     @Autowired
    InvoiceRepository invoiceRepository;
    public void createInvoice(invoice invoice) throws Exception{
        invoiceRepository.save(invoice);
    }
}
