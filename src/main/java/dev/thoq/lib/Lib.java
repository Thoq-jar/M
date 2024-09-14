package dev.thoq.lib;

import dev.thoq.Main;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import static java.lang.System.out;

public class Lib {
  public static double eval(String expression) {
    Expression exp = new ExpressionBuilder(expression)
        .variables(Main.assignments.keySet())
        .build()
        .setVariables(Main.assignments);
    return exp.evaluate();
  }

  public static void log(String message) {
    out.println(message);
  }
}
