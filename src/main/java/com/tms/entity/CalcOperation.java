package com.tms.entity;

import java.time.LocalDate;
//TODO добавить переменную ID

public class CalcOperation {
    private double number1;
    private double number2;
    private String operation;
    private double result;
    private String username;
    private LocalDate date;

    public CalcOperation(double number1, double number2, String operation, double result, String username) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
        this.username = username;
    }

    public CalcOperation(double number1, double number2, String operation, double result, String username, LocalDate date) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
        this.username = username;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getNum1() {
        return number1;
    }

    public void setNum1(double number1) {
        this.number1 = number1;
    }

    public double getNum2() {
        return number2;
    }

    public void setNum2(double number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                ", username='" + username + '\'' +
                ", date=" + date +
                '}';
    }
}

