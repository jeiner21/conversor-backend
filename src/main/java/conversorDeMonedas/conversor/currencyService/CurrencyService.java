package conversorDeMonedas.conversor.currencyService;

import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private final String API_KEY = "f4fb1db660e2b736ac014d7a";

    public double conversor(String origen, String destiny, double amount) {
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s", API_KEY,
                origen.toUpperCase(),
                destiny.toUpperCase());

        RestTemplate restTemplate = new RestTemplate();
        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response == null || !"success".equals(response.get("result"))) {
            throw new RuntimeException("Error al consultar la api externa");
        }

        double tasa = (double) response.get("conversion_rate");
        return amount * tasa;
    }
}
