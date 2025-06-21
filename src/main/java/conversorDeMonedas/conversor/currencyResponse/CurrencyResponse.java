package conversorDeMonedas.conversor.currencyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse {
    private String moneyOrigen;
    private String moneyFinal;
    private double amount;
    private double result;

}
