package com.mind.entity;

public class Calculator {

    Integer value;

    public Integer sum(Integer firstOperator, Integer secondOperator) {
        return firstOperator + secondOperator;
    }

    public Integer addValue(Integer value) {
        if(value < 0) {
            throw new NegativeNumberException();
        }
        return this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}