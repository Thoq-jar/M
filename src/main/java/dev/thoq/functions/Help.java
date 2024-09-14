package dev.thoq.functions;

import static java.lang.System.out;

public class Help {
  public static void helpMenu() {
    out.println(" -- M Help --");
    out.println(" To evaluate a basic ex (eg. +, -, *, /) use eval [expression here]");
    out.println(" To classify a number (eg. 1, 5, -54) use classify [number here]");
    out.println(" To evaluate an algebraic expression (eg. x = 5, y = 3, 2*x + 3*y - 4) use alg->ex [expression here]");
    out.println(" To calculate the square root, use sqrt [number or expression here]");
    out.println(" To assign values to variables, use x = value y = value");
    out.println(" To exit, enter: exit [] or quit []");
  }
}
