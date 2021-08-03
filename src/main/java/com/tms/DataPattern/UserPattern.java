package com.tms.DataPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPattern {

    public boolean checkByUserDataPattern(String name, String username, String password) {


        if (username != null & !username.trim().isEmpty() &
                password != null & !password.trim().isEmpty() &
                name != null & !name.trim().isEmpty()) {

            final Pattern namePattern = Pattern.compile("(?=\\S+$).{2,16}", Pattern.CASE_INSENSITIVE);
            final Pattern passwordPattern = Pattern.compile("(?=.*[0-9])(?=\\S+$).{5,20}", Pattern.CASE_INSENSITIVE);
            final Pattern usernamePattern = Pattern.compile("(?=\\S+$).{2,16}", Pattern.CASE_INSENSITIVE);
            Matcher matcherPassword = passwordPattern.matcher(password);
            Matcher matcherUsername = usernamePattern.matcher(username);
            Matcher matcherName = namePattern.matcher(name);
            return matcherPassword.find() & matcherUsername.find() & matcherName.find();
        }
        return false;
    }

    public boolean usernamePattern(String username) {

        if (username != null & !username.trim().isEmpty()) {

            final Pattern usernamePattern = Pattern.compile("(?=\\S+$).{2,16}", Pattern.CASE_INSENSITIVE);
            Matcher matcherUsername = usernamePattern.matcher(username);
            return matcherUsername.find();
        }
        return false;
    }

    public boolean checkingPasswordUsernameByPattern(String password, String username) {

        if (username != null & !username.trim().isEmpty() &
                password != null & !password.trim().isEmpty()) {

            final Pattern passwordPattern = Pattern.compile("(?=.*[0-9])(?=\\S+$).{5,20}", Pattern.CASE_INSENSITIVE);
            final Pattern usernamePattern = Pattern.compile("(?=\\S+$).{2,16}", Pattern.CASE_INSENSITIVE);
            Matcher matcherPassword = passwordPattern.matcher(password);
            Matcher matcherUsername = usernamePattern.matcher(username);
            return matcherPassword.find() & matcherUsername.find();
        }
        return false;
    }

    public boolean checkPasswordByPattern(String password) {

        if (password != null & !password.trim().isEmpty()) {

            final Pattern passwordPattern = Pattern.compile("(?=.*[0-9])(?=\\S+$).{5,20}", Pattern.CASE_INSENSITIVE);
            Matcher matcherPassword = passwordPattern.matcher(password);
            return matcherPassword.find();
        }
        return false;
    }
}


