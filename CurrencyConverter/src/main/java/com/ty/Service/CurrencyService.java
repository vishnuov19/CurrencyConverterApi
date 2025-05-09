package com.ty.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ty.Exceptions.CurrencyApiException;
import com.ty.Exceptions.InvalidCurrencyException;
@Component
@Service
public class CurrencyService {
	 private final String API_URL = "https://v6.exchangerate-api.com/v6/774dad036c3d178b8eb9ceb6/latest/%s";

	    public Map<String, Double> getRates(String base) {
	        try {
	            RestTemplate restTemplate = new RestTemplate();
	            String url = String.format(API_URL, base);
	            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

	            if (!response.containsKey("conversion_rates")) {
	                throw new CurrencyApiException("Invalid response from currency API.");
	            }

	            Map<String, Object> ratesRaw = (Map<String, Object>) response.get("conversion_rates");
	            Map<String, Double> rates = new HashMap<>();

	            for (Map.Entry<String, Object> entry : ratesRaw.entrySet()) {
	                Object value = entry.getValue();
	                if (value instanceof Number) {
	                    rates.put(entry.getKey(), ((Number) value).doubleValue());
	                }
	            }

	            return rates;
	        } catch (Exception e) {
	            throw new CurrencyApiException("Failed to fetch exchange rates: " + e.getMessage());
	        }
	    }

	    public double convert(String from, String to, double amount) {
	        Map<String, Double> rates = getRates(from);
	        if (!rates.containsKey(to)) {
	            throw new InvalidCurrencyException("Invalid currency code: " + to);
	        }
	        return amount * rates.get(to);
	    }


}
