package com.tms.service;

import com.tms.DAO.calculator.CalcOperationDAO;
import com.tms.entity.CalcOperation;
import com.tms.entity.User;

import java.util.List;

public class CalcService {
    private final CalcOperationDAO operationDAO = new CalcOperationDAO();


    public CalcOperation calc(double a, double b, String operation, User user) {

        switch (operation) {
            case "sum":
                CalcOperation operation1 = new CalcOperation(a, b, operation, a + b, user.getUsername());
                operationDAO.save(operation1);
                return operation1;
            case "sub":
                CalcOperation operation2 = new CalcOperation(a, b, operation, a - b, user.getUsername());
                operationDAO.save(operation2);
                return operation2;
            case "mul":
                CalcOperation operation3 = new CalcOperation(a, b, operation, a * b, user.getUsername());
                operationDAO.save(operation3);
                return operation3;
            case "div":
                CalcOperation operation4 = new CalcOperation(a, b, operation, a / b, user.getUsername());
                operationDAO.save(operation4);
                return operation4;
        }
        return null;
    }

    public double calculate(double a, double b, String operation) {
        switch (operation) {
            case "sum":
                return sum(a, b);
            case "sub":
                return sub(a, b);
            case "mul":
                return mul(a, b);
            case "div":
                return div(a, b);

        }
        return 0;
    }

    private double sum(double a, double b) {
        return a + b;
    }

    private double sub(double a, double b) {
        return a - b;
    }

    private double mul(double a, double b) {
        return a * b;
    }

    private double div(double a, double b) {
        return a / b;
    }

    public List<CalcOperation> findAll() {
        return operationDAO.getAll();
    }

    public void deleteFromCalcHistoryByUsername(String username){
        operationDAO.deleteByUsernameFromCalcHistory(username);
    }

    public boolean existsByUsernameCalcHistory(String username){
        return operationDAO.existsByUsernameCalcHistory(username);
    }

    public void updateUsernameInCalcHistory(User user, String newUsername){
operationDAO.updateUsernameInCalcHistory(user, newUsername);
    }
}


