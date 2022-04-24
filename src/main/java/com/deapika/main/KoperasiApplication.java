package com.deapika.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.deapika"})
public class KoperasiApplication {

  public static void main(String[] args) {
    SpringApplication.run(KoperasiApplication.class, args);
  }
}
