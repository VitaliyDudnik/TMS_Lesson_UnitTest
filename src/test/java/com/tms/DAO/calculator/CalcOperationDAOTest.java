package com.tms.DAO.calculator;

import com.tms.entity.CalcOperation;
import com.tms.entity.User;
import com.tms.service.CalcService;
import com.tms.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalcOperationDAOTest {
    private final CalcService calculatorService = new CalcService();
    private final UserService userService = new UserService();
    private static final Logger log = LoggerFactory.getLogger(CalcOperationDAOTest.class);
    private User user;

    @BeforeEach
    void star() {
        log.info("Start");
    }

    @AfterEach
    void end() {
        log.info("end");
    }

    @Test
    @DisplayName("save user operations in calcDAO")
    void save() {
        log.info("save user operations in calcDAO");
        String username = "username";
        user = userService.getByUsername(username);
        calculatorService.calc(1, 2, "sum", user);
    }

    @Test
    @DisplayName("testing simple calculator operation")
    void calc() {
        log.info("testing simple calculator operation");
        assertAll(
                () -> assertEquals(2, calculatorService.calculate(1, 1, "sum"), "1+1=2"),
                () -> assertEquals(4, calculatorService.calculate(2, 2, "mul"), "2*2=4"),
                () -> assertEquals(1, calculatorService.calculate(2, 2, "div"), "2/2=1"),
                () -> assertEquals(0, calculatorService.calculate(2, 2, "sub"), "2-2=0"));
    }

    @Test
    @DisplayName("get all users to the list from calculator operation history")
    void getAll() {

        log.info("get all users to the list from calculator operation history");
        List<CalcOperation> calcOperationList;
        calcOperationList = calculatorService.findAll();

        if (calcOperationList != null) {
            assertFalse(calcOperationList.isEmpty());
        } else {
            Exception exception = new Exception();
            log.trace(exception.getMessage());
        }
    }

    @Test
    void deleteByUsernameFromCalcHistory() {

        log.info("delete by username from calc history");
        String username = "username";

        user = userService.getByUsername(username);
        if (user != null) {
            calculatorService.deleteFromCalcHistoryByUsername(user.getUsername());
        } else {
            log.error("user is null");
        }
    }

    @Test
    void checkingForUserAvailable() {
        log.info("testing deleteByUsernameFromCalcHistory and method existsByUsernameCalcHistory(String username)");
        String username = "username";
        assertFalse(calculatorService.existsByUsernameCalcHistory(username), "expected false for exists result");
    }

    @Test
    void updateUsernameCalcHistory() {
        log.info("update username in calcDAO");

        String newUsername = "Vitaliy87";
        String actualUsername = "Vitaliy";
        user = userService.getByUsername(actualUsername);

        if (user != null) {
            calculatorService.updateUsernameInCalcHistory(user, newUsername);
        } else {
            log.error("user is null");
        }
    }

    @Test
    @DisplayName("testing deleteByUsernameFromCalcHistory and method existsByUsernameCalcHistory(String username)")
    void checkingUserAvailable() {
        String username = "Vitaliy87";
        assertTrue(calculatorService.existsByUsernameCalcHistory(username), "expected true for exists result");
    }

    @Test
    void exceptionTesting() {
        log.info("testing for ArithmeticException");
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculatorService.calculate(1, 0, "div"));
        assertEquals("/ by zero", exception.getMessage());
    }
}