package com.deapika.declare;

public interface AppDeclare {
  String  databaseHost                               = "localhost";
  String  databaseName                               = "koperasi";
  String  databasePort                               = "5432";
  String  driver                                     = "com.mysql.cj.jdbc.Driver";
  String  url                                        = "jdbc:postgresql://"+databaseHost+":"+databasePort+"/"+databaseName;
  String  user = "postgres";
  String  password = "password";
  long    bukuBesar = Long.MAX_VALUE;

  /* TABEL DATA */
  String  tAnggota                               = "anggota";
  String  tTxAcct                               = "tx_acct";
  String  tHistory                               = "history";
  
  /* TRANSAKSI */
  String  TX_MENYERAHKAN    = "MENYERAHKAN";
  String  TX_MENGAMBIL      = "MENGAMBIL";
  String  TX_MEMINJAM       = "MEMINJAM";
  String  TX_MENGEMBALIKAN  = "MENGEMBALIKAN";
}