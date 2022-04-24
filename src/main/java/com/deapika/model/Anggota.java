package com.deapika.model;

/**
 *
 * @author Taufik
 */
public class Anggota {
  private Long id;
  private String name;
  private String tglLahir;
  private String alamat;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTglLahir() {
    return tglLahir;
  }

  public void setTglLahir(String tglLahir) {
    this.tglLahir = tglLahir;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }
  
}
