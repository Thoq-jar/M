package dev.thoq.handlers;

import com.google.common.collect.ImmutableMap;
import dev.thoq.Main;
import dev.thoq.functions.Classify;
import dev.thoq.functions.EvalEx;
import dev.thoq.functions.Help;
import dev.thoq.lib.Lib;
import dev.thoq.lib.Screen;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Handlers {
  public static void classifyHandler(String inputNum) {
    try {
      BigDecimal number = new BigDecimal(inputNum);
      String result = Classify.classify(number.doubleValue());
      Screen.println(result);
    } catch (NumberFormatException e) {
      Screen.println(" Invalid number format.");
    }
  }

  public static void evalExHandler(String expression) {
    EvalEx.evalEx(expression);
  }

  public static void clearHandler(String input) {
    Screen.clear();
    if (!input.isEmpty()) Screen.println(" Command 'clear' doesn't take any arguments.");
  }

  public static void algExHandler(String inputEx) {
    try {
      String[] parts = inputEx.split(",");
      StringBuilder expression = new StringBuilder();
      Map<String, BigDecimal> newAssignments = new HashMap<>();

      for (String part : parts) {
        part = part.trim();
        if (part.contains("=")) {
          String[] assignment = part.split("=");
          newAssignments.put(assignment[0].trim(), new BigDecimal(assignment[1].trim()));
        } else {
          expression.append(part).append(" ");
        }
      }

      Main.assignments = ImmutableMap.copyOf(newAssignments);
      String expr = expression.toString().trim();
      BigDecimal result = Lib.eval(expr);
      Screen.println(" " + result.toPlainString());
    } catch (Exception e) {
      Screen.println(" Error evaluating algebraic expression: " + e.getMessage());
    }
  }

  public static void sqrtHandler(String inputEx) {
    try {
      BigDecimal number = new BigDecimal(inputEx);
      BigDecimal result = BigDecimal.valueOf(Math.sqrt(number.doubleValue()));
      Screen.println(" " + result.toPlainString());
    } catch (Exception e) {
      Screen.println(" Error calculating square root: " + e.getMessage());
    }
  }

  public static void sciNotHandler(String inputEx) {
    try {
      BigDecimal number = new BigDecimal(inputEx);
      DecimalFormat df = new DecimalFormat("#.##");
      String formattedResult = df.format(number);
      Screen.println(" " + formattedResult);
    } catch (NumberFormatException e) {
      Screen.println(" Error parsing number: " + e.getMessage());
    } catch (Exception e) {
      Screen.println(" Error calculating: " + e.getMessage());
    }
  }

  public static void helpHandler(String input) {
    Help.helpMenu(input);
  }

  public static void exitHandler() {
    exit(0);
  }

  public static void piHandler(String inputEx) {
    try {
      boolean override = !inputEx.contains("1000");

      if (!override) {
        Screen.println(" Please enter a value below 1000! (Override with !)");
        return;
      }

      BigDecimal pi = calculatePi(Integer.parseInt(inputEx));
      Screen.println(" " + pi.toPlainString());
    } catch (NumberFormatException e) {
      Screen.println(" Invalid number format.");
    } catch (Exception e) {
      Screen.println(" Error calculating pi: " + e.getMessage());
    }
  }

  public static void piOverrideHandler(String inputEx) {
    try {
      int digits = Integer.parseInt(inputEx);

      if (digits < 0) {
        Screen.println(" Number of digits must be non-negative.");
        return;
      }

      BigDecimal pi = calculatePi(digits);
      Screen.println(" " + pi.toPlainString());
    } catch (NumberFormatException e) {
      Screen.println(" Invalid number format.");
    } catch (Exception e) {
      Screen.println(" Error calculating pi: " + e.getMessage());
    }
  }

  public static void piGenHandler(String inputEx) {
    if (!inputEx.isEmpty()) Screen.println(" The command 'pi->gen' doesnt take any arguments.");
    Screen.println(" " + Math.PI);
  }

  private static BigDecimal calculatePi(int digits) {
    MathContext mc = new MathContext(digits + 2);
    BigDecimal pi;

    BigDecimal C = new BigDecimal(426880).multiply(BigDecimal.valueOf(Math.sqrt(10005)).round(mc));
    BigDecimal K = BigDecimal.ZERO;
    BigDecimal M = BigDecimal.ONE;
    BigDecimal X = BigDecimal.ONE;
    BigDecimal L = new BigDecimal(13591409);
    BigDecimal S = L;

    for (int i = 1; i < digits; i++) {
      K = K.add(BigDecimal.valueOf(12));
      M = M.multiply(K).divide(BigDecimal.valueOf(i), mc);
      X = X.multiply(BigDecimal.valueOf(-262537412640768000L));
      L = L.add(BigDecimal.valueOf(545140134));
      S = S.add(M.multiply(X).divide(L, mc));
    }

    pi = C.divide(S, mc);
    return pi.round(mc).stripTrailingZeros();
  }
}
