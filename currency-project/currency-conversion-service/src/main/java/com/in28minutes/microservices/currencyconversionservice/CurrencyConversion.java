package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigInteger;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigInteger conversionMultiple;
    private BigInteger quantity;
    private BigInteger totalCalculatedAmount;
    private String evironment;
    CurrencyConversion(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigInteger getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigInteger conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigInteger totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return evironment;
    }

    public void setEnvironment(String environment) {
        this.evironment = environment;
    }

    public CurrencyConversion(Long id, String from, String to, BigInteger conversionMultiple, BigInteger quantity, BigInteger totalCalculatedAmount,String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.evironment=environment;
       }
}
