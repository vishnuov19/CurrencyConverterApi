package com.ty.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.ty.Service.CurrencyService;

public class CurrencyServiceTest {
	  CurrencyService currencyService = new CurrencyService();

	    @Test
	    void testGetRates_validBaseCurrency() {
	        Map<String, Double> rates = currencyService.getRates("USD");
	        assertNotNull(rates);
	        assertTrue(rates.containsKey("INR")); // You can check for any expected currency
	    }

	    @Test
	    void testConvert_validCurrencies() {
	        double convertedAmount = currencyService.convert("USD", "INR", 100);
	        assertTrue(convertedAmount > 0);
	    }

	    @Test
	    void testConvert_invalidCurrency() {
	        Exception exception = assertThrows(RuntimeException.class, () -> {
	            currencyService.convert("USD", "INVALID_CODE", 100);
	        });

	        System.out.println("Actual exception message: " + exception.getMessage());
	        assertNotNull(exception.getMessage());
	        assertTrue(exception.getMessage().toLowerCase().contains("invalid"));
	    }
}
