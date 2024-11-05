
package app.Controllervalidator;


public class InvoiceDetailValidator extends CommonsValidator{

    public InvoiceDetailValidator() {
        super();
    }
    public int validItem(String item) throws Exception{
		return super.isValidInteger("el item ", item);
	}
    public void validDescription(String description)throws Exception {
		super.isValidString("La descripcion de la factura", description);
        
	}
    public double validAmount(String amount)throws Exception {
		return super.isValidDouble("Monto de la factura", amount);
        
	}
}
