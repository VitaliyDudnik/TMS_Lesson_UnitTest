package com.tms.DAO.calculator;

import com.tms.DAO.connection.ConnectionDAO;
import com.tms.entity.CalcOperation;
import com.tms.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalcOperationDAO extends ConnectionDAO {
    LocalDate localDate = LocalDate.now();

    public void save(CalcOperation o) {
        try {
            if (o != null) {
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement("insert into calc values (default , ?, ?,?,?,?,?)");
                preparedStatement.setString(1, o.getUsername());
                preparedStatement.setDouble(2, o.getNum1());
                preparedStatement.setDouble(3, o.getNum2());
                preparedStatement.setString(4, o.getOperation());
                preparedStatement.setDouble(5, o.getResult());
                preparedStatement.setObject(6, localDate);
                preparedStatement.execute();
                connection.commit();
            } else {
                return;
            }
        } catch (SQLException throwables) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public List<CalcOperation> getAll() {
        List<CalcOperation> operationList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from calc");
            while (resultSet.next()) {
                String username = resultSet.getString(2);
                double number1 = resultSet.getDouble(3);
                double number2 = resultSet.getDouble(4);
                String operation = resultSet.getString(5);
                double result = resultSet.getDouble(6);
                LocalDate localDate = resultSet.getObject(7, LocalDate.class);
                CalcOperation CalcOperation = new CalcOperation(number1, number2, operation, result, username, localDate);
                operationList.add(CalcOperation);
            }
            return new ArrayList<>(operationList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteByUsernameFromCalcHistory(String username) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from calc where username = ?");
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean existsByUsernameCalcHistory(String username){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select username from calc where username = ?");
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return false;
        }
        
    public void updateUsernameInCalcHistory(User user, String newUsername) {

        try {
            if(newUsername != null &  user!=null & !newUsername.trim().isEmpty()) {
                PreparedStatement preparedStatement = connection.prepareStatement("update calc set username = ? where username = ?");
                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.execute();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
