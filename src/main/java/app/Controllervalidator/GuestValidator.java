
package app.Controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class GuestValidator extends CommonsValidator {
     public boolean validStatus(String status)throws Exception {
		return super.isValidBoolean("Estado de la factura", status);
    }
    
}
