package com.deapika.controller;

import com.deapika.model.Transaction;
import com.deapika.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Taufik
 */
@RestController
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  @RequestMapping(value = "/transaction", method = RequestMethod.POST)
  public ResponseEntity<Object> createTransaction(@RequestBody Transaction transaction) {
    transactionService.transaction(transaction);
    return new ResponseEntity<>("Transaksi berhasil ditambahkan.", HttpStatus.CREATED);
  }
}
