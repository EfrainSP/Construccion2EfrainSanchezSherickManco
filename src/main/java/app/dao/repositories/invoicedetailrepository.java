/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repositories;

import app.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sherick
 */
public interface invoicedetailrepository extends JpaRepository <InvoiceDetail,Long> {
    
}
