package com.example.desgining_contracts.src.java.main;

class TaxCalculator {
    public double calculateTax(double value) {
        if (value < 0) {
            throw new RuntimeException("value cannot be negative");
        }
        // replace above if with assert :
        assert value >= 0 : "value cannot be negative";
        double taxValue = 0;
        if (taxValue < 0) {
            throw new RuntimeException("calculated tax value cannot be negative");
        }
        //replace this if with assert :
        assert value >= 0 : "calculated tax value cannot be negative";
        return taxValue;
    }
}
