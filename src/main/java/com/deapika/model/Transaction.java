package com.deapika.model;

import java.math.BigDecimal;

/**
 *
 * @author Taufik
 */
public class Transaction {
  private Long id;
  private String tglTransaksi;
  private long idAnggota;
  private long debitAcct;
  private long kreditAcct;
  private String typeAcct;
  private BigDecimal nominal;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTglTransaksi() {
    return tglTransaksi;
  }

  public void setTglTransaksi(String tglTransaksi) {
    this.tglTransaksi = tglTransaksi;
  }

  public long getIdAnggota() {
    return idAnggota;
  }

  public void setIdAnggota(long idAnggota) {
    this.idAnggota = idAnggota;
  }

  public long getDebitAcct() {
    return debitAcct;
  }

  public void setDebitAcct(long debitAcct) {
    this.debitAcct = debitAcct;
  }

  public long getKreditAcct() {
    return kreditAcct;
  }

  public void setKreditAcct(long kreditAcct) {
    this.kreditAcct = kreditAcct;
  }

  public String getTypeAcct() {
    return typeAcct;
  }

  public void setTypeAcct(String typeAcct) {
    this.typeAcct = typeAcct;
  }

  public BigDecimal getNominal() {
    return nominal;
  }

  public void setNominal(BigDecimal nominal) {
    this.nominal = nominal;
  }

}
