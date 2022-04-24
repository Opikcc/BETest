package com.deapika.impl;

import com.deapika.Util.DBConn;
import com.deapika.declare.AppDeclare;
import com.deapika.model.Anggota;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.deapika.service.AnggotaService;
import java.sql.PreparedStatement;
import org.springframework.stereotype.Service;

/**
 *
 * @author Taufik
 */
@Service
public class AnggotaServiceImpl implements AppDeclare, AnggotaService {
  private Connection conn;

  @Override
  public List<Anggota> getDaftarAnggota() {
    
    List<Anggota> listAnggota = new ArrayList();
    
    try {
      conn  = new DBConn().getConnection();
      
      String sql = " SELECT id, " +
                   "        name, " +
                   "        tgl_lahir, " +
                   "        alamat " +
                   " FROM " + tAnggota;
      Statement stmt = conn.createStatement();
      boolean hasResults = stmt.execute(sql);
      if (hasResults) {
        ResultSet result = stmt.getResultSet();
        while (result.next()) {
          Anggota beanAnggota = new Anggota();
          
          beanAnggota.setId(result.getLong("id"));
          beanAnggota.setName(result.getString("name"));
          beanAnggota.setTglLahir(result.getString("tgl_lahir"));
          beanAnggota.setAlamat(result.getString("alamat"));
          
          listAnggota.add(beanAnggota);
        }
        result.close();
      }
      stmt.close();
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    finally {
      try {
        conn.close();
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    
    return listAnggota;
  }

  @Override
  public void addAnggota(Anggota anggota) {
    PreparedStatement stmt;
    
    try {
      conn  = new DBConn().getConnection();

      String sql =  " INSERT INTO "+ tAnggota +
                    " (" +
                    " name,       " +
                    " tgl_lahir,  " +
                    " alamat      " +
                    " ) VALUES ( " +
                    " ?, ?, ?)" ;
      stmt = conn.prepareStatement(sql);
      stmt.setString   ( 1, anggota.getName());
      stmt.setString   ( 2, anggota.getTglLahir());
      stmt.setString   ( 3, anggota.getAlamat());
      stmt.executeUpdate();
      stmt.close();
    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    finally {
      try {
        conn.close();
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
  
}
