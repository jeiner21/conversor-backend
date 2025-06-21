package conversorDeMonedas.conversor.currencyRequest;

import lombok.Data;

@Data
public class CurrencyRequest {
    private String moneyOrigen;
    private String moneyFinal;
    private double amount;
}
