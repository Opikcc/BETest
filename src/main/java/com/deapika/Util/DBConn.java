package com.deapika.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deapika.declare.AppDeclare;

public class DBConn implements AppDeclare {
  private Connection connection;

  public DBConn() {
    try {
      createConnection();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public Connection getConnection() {
    try {
      boolean isValid = (connection!=null) && !connection.isClosed();
      if (!isValid) {
        createConnection();
        return getConnection();
      }
      else {
        return connection;
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return null;
  }

  public boolean isConnectionValid () {
    boolean isValid = false;
    try {
      isValid = (connection!=null) && !connection.isClosed();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

    return isValid;
  }

  private void closeConnection () {
    try {
      if (connection != null) {
        connection.close ();
        connection = null;
      }
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  private boolean createConnection() {
    try {
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Connected to the PostgreSQL server successfully.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }

    return true;
  }

}
