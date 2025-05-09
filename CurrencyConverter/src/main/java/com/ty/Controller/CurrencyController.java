package com.ty.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Models.ConvertRequest;
import com.ty.Models.ConverteResponse;
import com.ty.Service.CurrencyService;

@RestController
public class CurrencyController {
	@Autowired
	CurrencyService currencyService;
	
	@GetMapping("/rates")
	 public Map<String, Double> getRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyService.getRates(base);
    }
	@PostMapping("/convert")
    public ConverteResponse convert(@RequestBody ConvertRequest request) {
        double result = currencyService.convert(request.getFrom(), request.getTo(), request.getAmount());
        return new ConverteResponse(request.getFrom(), request.getTo(), request.getAmount(), result);
    }
	

}
