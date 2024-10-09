package dev.thoq.handlers;

import dev.thoq.lib.Screen;

public class CmdProcessor {
  public static void evl(String command, String inputEx) {
    Screen.println(" " + command + " |" + inputEx + "|");
    switch (command) {
      case "eval":
        Handlers.evalExHandler(inputEx);
        break;
      case "classify":
        Handlers.classifyHandler(inputEx);
        break;
      case "poly":
        Handlers.algExHandler(inputEx);
        break;
      case "sqrt":
        Handlers.sqrtHandler(inputEx);
        break;
      case "help":
        Handlers.helpHandler(inputEx);
        break;
      case "sci->not":
        Handlers.sciNotHandler(inputEx);
        break;
      case "pi->gen":
        Handlers.piGenHandler(inputEx);
        break;
      case "pi":
        Handlers.piHandler(inputEx);
      case "pi!":
        Handlers.piOverrideHandler(inputEx);
        break;
      case "exit":
      case "quit":
        Handlers.exitHandler();
        break;
      case "clear":
        Handlers.clearHandler(inputEx);
        break;
      default:
        Screen.println(" Command not supported!");
        break;
    }
  }
}
