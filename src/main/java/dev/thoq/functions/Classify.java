package dev.thoq.functions;

public class Classify {
  public static String classify(double number) {
    if (Double.isNaN(number)) {
      return " NaN";
    }

    if (number % 1 == 0) {
      int intNumber = (int) number;

      return switch (Integer.signum(intNumber)) {
        case -1 ->
            " Integer (Negative)";
        case 0 ->
            " Whole Number (Zero)";
        case 1 ->
            " Natural Number";
        default -> " Not a valid number";
      };
    } else {
      return " Irrational";
    }
  }
}