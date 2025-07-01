package conversorDeMonedas.conversor.currencyController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import conversorDeMonedas.conversor.currencyRequest.CurrencyRequest;
import conversorDeMonedas.conversor.currencyResponse.CurrencyResponse;
import conversorDeMonedas.conversor.currencyService.CurrencyService;

@RestController
@RequestMapping("/convert")
@CrossOrigin(origins = "*")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @PostMapping
    public CurrencyResponse convertir(@RequestBody CurrencyRequest request) {
        double resultado = service.conversor(
                request.getMoneyOrigen(),
                request.getMoneyFinal(),
                request.getAmount());

        return new CurrencyResponse(
                request.getMoneyOrigen(),
                request.getMoneyFinal(),
                request.getAmount(),
                resultado);
    }

    @GetMapping("/money")
    public List<String> obtenerMonedas() {
        String url = String.format("https://v6.exchangerate-api.com/v6/f4fb1db660e2b736ac014d7a/codes");

        RestTemplate restTemplate = new RestTemplate();

        @SuppressWarnings("unchecked")
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response == null || !"success".equals(response.get("result"))) {
            throw new RuntimeException("No se pudieron obtener las monedas");
        }
        @SuppressWarnings("unchecked")
        List<List<String>> codes = (List<List<String>>) response.get("supported_codes");

        return codes.stream().map(codePair -> codePair.get(0)).toList();
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

}
