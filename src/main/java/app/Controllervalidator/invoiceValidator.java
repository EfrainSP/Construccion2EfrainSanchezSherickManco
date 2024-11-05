
package app.Controllervalidator;

import org.springframework.stereotype.Component;

@Component
public class invoiceValidator extends CommonsValidator {
    public invoiceValidator() {
		super();
	} 
    
    public double validAmount(String amount) throws Exception{
		return super.isValidDouble("el monto de la factura ", amount);
	}
    public boolean validItems(String status)throws Exception {
		return super.isValidBoolean("Estado de la factura", status);
        
	}
    
}
