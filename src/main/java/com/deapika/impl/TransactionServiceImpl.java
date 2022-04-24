package com.deapika.impl;

import com.deapika.Util.DBConn;
import com.deapika.Util.DateTool;
import com.deapika.declare.AppDeclare;
import com.deapika.model.Transaction;
import java.sql.Connection;
import java.sql.SQLException;
import com.deapika.service.TransactionService;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Taufik
 */
@Service
public class TransactionServiceImpl implements AppDeclare, TransactionService {
  private Connection conn;

  @Override
  public boolean transaction(Transaction transaction) {
    boolean isSuccess = false;
    
    if (validateTransaction(transaction)) {
      execTransaction(transaction);
      isSuccess = true;
    }
    
    return isSuccess;
  }
  
  private void execTransaction(Transaction tx) {
    PreparedStatement stmt;
    
    switch(tx.getTypeAcct()) {
      case TX_MENYERAHKAN :
        tx.setDebitAcct(tx.getIdAnggota());
        tx.setKreditAcct(bukuBesar);
        break;
      case TX_MENGAMBIL :
        tx.setDebitAcct(bukuBesar);
        tx.setKreditAcct(tx.getIdAnggota());
        break;
      case TX_MEMINJAM :
        tx.setDebitAcct(tx.getIdAnggota());
        tx.setKreditAcct(bukuBesar);
        break;
      case TX_MENGEMBALIKAN :
        tx.setDebitAcct(bukuBesar);
        tx.setKreditAcct(tx.getIdAnggota());
        break;
      default:
        break;
    }
    
    try {
      conn  = new DBConn().getConnection();

      String sql =  " INSERT INTO "+ tTxAcct +
                    " (" +
                    " tgl_transaksi,  " +
                    " debit_acct,     " +
                    " kredit_acct,    " +
                    " type_acct,      " +
                    " nominal         " +
                    " ) VALUES ( " +
                    " ?, ?, ?, ?, ?)" ;
      stmt = conn.prepareStatement(sql);
      stmt.setString      ( 1, tx.getTglTransaksi());
      stmt.setLong        ( 2, tx.getDebitAcct());
      stmt.setLong        ( 3, tx.getKreditAcct());
      stmt.setString      ( 4, tx.getTypeAcct());
      stmt.setBigDecimal  ( 5, tx.getNominal());
      int result = stmt.executeUpdate();
      stmt.close();
      
      if (result > 0) {
        sql =  " INSERT INTO "+ tHistory +
                " (" +
                " tgl_transaksi,  " +
                " debit_acct,     " +
                " kredit_acct,    " +
                " type_acct,      " +
                " nominal         " +
                " ) VALUES ( " +
                " ?, ?, ?, ?, ?)" ;
        stmt = conn.prepareStatement(sql);
        stmt.setString      ( 1, tx.getTglTransaksi());
        stmt.setLong        ( 2, tx.getDebitAcct());
        stmt.setLong        ( 3, tx.getKreditAcct());
        stmt.setString      ( 4, tx.getTypeAcct());
        stmt.setBigDecimal  ( 5, tx.getNominal());
        stmt.executeUpdate();
        stmt.close();
      }
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
  
  private boolean validateTransaction(Transaction transaction) {
    boolean isValid = true;
    
    LocalDate today = LocalDate.now();
    LocalDate txDate = DateTool.parseDate(transaction.getTglTransaksi());
    boolean isAfter = today.isAfter(txDate);
    
    if (transaction.getNominal().compareTo(BigDecimal.ZERO) == -1)
      isValid = false;
    else if (isAfter)
      isValid = false;
    
    return isValid;
  }
}
