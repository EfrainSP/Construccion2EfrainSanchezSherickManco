/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfaces.invoiceDetailDao;
import app.dao.repositories.invoicedetailrepository;
import app.model.InvoiceDetail;
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
public class invoicedetaildaoimplementation implements invoiceDetailDao{
     @Autowired
    invoicedetailrepository invoiceDetailRepository;
     
     @Override
    public void createInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
    }
}
