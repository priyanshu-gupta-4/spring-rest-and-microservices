package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
	
	private HashMap<String,String> uriVariables = new HashMap<>();
    @Autowired
	Environment environment;
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyExchange(@PathVariable String from,@PathVariable String to,@PathVariable BigInteger quantity){
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion=responseEntity.getBody();
        System.out.println(currencyConversion.getEnvironment());
        return new CurrencyConversion(currencyConversion.getId(),from,to, currencyConversion.getConversionMultiple(),quantity,quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
    }
    
    @Autowired
    private CurrencyExchangeProxy proxy;
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyExchangeFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigInteger quantity){
        CurrencyConversion currencyConversion=proxy.retriveExchangeValue(from, to);
        System.out.println(currencyConversion.getEnvironment());
        return new CurrencyConversion(currencyConversion.getId(),from,to, currencyConversion.getConversionMultiple(),quantity,quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
    }
}
