package ru.kpfu.itis.genatulin.entities;

public class Calculation {
    private Integer firstValue;
    private Integer secondValue;
    private String operation;
    private Integer result;

    public Calculation(Integer firstValue, Integer secondValue, String operation, Integer result) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }
}
