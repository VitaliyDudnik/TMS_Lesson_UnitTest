package com.tms.DAO.connection;

public class ConnectionParameterDAO {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "*****";

    public String getUrl() { return url; }

    public String getUser() { return user; }

    public String getPassword() { return password; }


}

