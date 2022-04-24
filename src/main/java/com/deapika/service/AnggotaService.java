package com.deapika.service;

import com.deapika.model.Anggota;
import java.util.List;

/**
 *
 * @author Taufik
 */
public interface AnggotaService {

  public List<Anggota> getDaftarAnggota();

  public void addAnggota(Anggota anggota);

}
