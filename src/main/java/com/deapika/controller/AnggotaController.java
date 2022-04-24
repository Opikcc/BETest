package com.deapika.controller;

import com.deapika.model.Anggota;
import com.deapika.service.AnggotaService;
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
public class AnggotaController {

  @Autowired
  private AnggotaService anggotaService;

  @RequestMapping(value = "/anggota")
  public ResponseEntity<Object> getAnggota() {

    return new ResponseEntity<>(anggotaService.getDaftarAnggota(), HttpStatus.OK);
  }

  @RequestMapping(value = "/anggota", method = RequestMethod.POST)
  public ResponseEntity<Object> createProduct(@RequestBody Anggota anggota) {
    anggotaService.addAnggota(anggota);
    return new ResponseEntity<>("Anggota berhasil ditambahkan.", HttpStatus.CREATED);
  }
}
