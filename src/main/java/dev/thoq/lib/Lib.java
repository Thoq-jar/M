package dev.thoq.lib;

import dev.thoq.Main;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Lib {
  public static BigDecimal eval(String expression) {
    Map<String, BigDecimal> currentAssignments = new HashMap<>(Main.assignments);

    Map<String, Double> doubleAssignments = new HashMap<>();
    for (Map.Entry<String, BigDecimal> entry : currentAssignments.entrySet()) {
      doubleAssignments.put(entry.getKey(), entry.getValue().doubleValue());
    }

    Expression exp = new ExpressionBuilder(expression)
        .variables(doubleAssignments.keySet())
        .build()
        .setVariables(doubleAssignments);

    return BigDecimal.valueOf(exp.evaluate());
  }
}