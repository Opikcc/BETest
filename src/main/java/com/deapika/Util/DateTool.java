package com.deapika.Util;

import java.time.LocalDate;

/**
 *
 * @author Taufik
 */
public class DateTool {
  
  public static LocalDate parseDate(String sDate) {
    LocalDate pDate;
    
    pDate = LocalDate.parse(sDate.substring(0, 4) + "-" + sDate.substring(4, 6) + "-" + sDate.substring(6));
    
    return pDate;
  }
}
