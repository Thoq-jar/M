package dev.thoq.functions;

public class Classify {
  public static String classify(double number) {
    if (Double.isNaN(number)) {
      return " NaN";
    }

    if (number % 1 == 0) {
      int intNumber = (int) number;

      switch (Integer.signum(intNumber)) {
        case -1: return " Integer (Negative)";
        case 0: return " Whole Number (Zero)";
        case 1: return " Natural Number";
        default: return " Not a valid number";
      }
    } else {
      return " Irrational";
    }
  }
}