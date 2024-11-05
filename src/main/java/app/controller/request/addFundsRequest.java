package app.controller.request;

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
public class addFundsRequest {
    private long partnerId;
    private double amount;
    private String username;
}
