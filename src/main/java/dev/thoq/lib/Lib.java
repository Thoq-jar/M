package dev.thoq.lib;

import dev.thoq.Main;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.HashMap;
import java.util.Map;

public class Lib {
  public static double eval(String expression) {
    Map<String, Double> currentAssignments = new HashMap<>(Main.assignments);

    Expression exp = new ExpressionBuilder(expression)
        .variables(currentAssignments.keySet())
        .build()
        .setVariables(currentAssignments);
    return exp.evaluate();
  }
}