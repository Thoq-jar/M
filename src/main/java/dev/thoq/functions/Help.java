package dev.thoq.functions;

import dev.thoq.lib.Screen;

public class Help {
  public static void helpMenu(String input) {
    if (!input.isEmpty()) Screen.println(" The 'help' command doesn't take arguments!");
    Screen.println("");
    Screen.println(" --- M Help ---");
    Screen.println(" --- Hint: If the command doesnt need args, you do not need the [], M will add them automatically ---");
    Screen.println(" -To evaluate a basic ex (eg. +, -, *, /) use eval [expression here]");
    Screen.println(" -To classify a number (eg. 1, 5, -54) use classify [number here]");
    Screen.println(" -To evaluate an algebraic expression (eg. x = 5, y = 3, 2*x + 3*y - 4) use alg->ex [expression here]");
    Screen.println(" -To calculate the square root, use sqrt [number or expression here]");
    Screen.println(" -To assign values to variables, use x = value y = value");
    Screen.println(" -To view the help menu (this screen), enter: `help []`");
    Screen.println(" -To clear the screen, enter: `clear []`");
    Screen.println(" -To exit, enter: `exit []` or `quit []`");
  }
}
