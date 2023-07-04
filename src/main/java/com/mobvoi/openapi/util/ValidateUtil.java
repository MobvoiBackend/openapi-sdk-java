package com.mobvoi.openapi.util;

import com.mobvoi.openapi.exception.OpenapiException;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author mobvoi
 * @date 2023/06/07
 **/
public class ValidateUtil {

  private ValidateUtil() {
  }

  public static void isTrue(boolean expression, String format, Object... args) {
    if (!expression) {
      String message = MessageFormatter.arrayFormat(format, args).getMessage();
      throw new OpenapiException(message);
    }
  }

}
