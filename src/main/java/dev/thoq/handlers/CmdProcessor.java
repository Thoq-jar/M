package dev.thoq.handlers;

import static java.lang.System.out;

public class CmdProcessor {
  static void evl(String command, String inputEx) {
    switch (command) {
      case "eval": Handlers.evalExHandler(inputEx);
      case "classify": Handlers.classifyHandler(inputEx);
      case "alg->ex": Handlers.algExHandler(inputEx);
      case "sqrt": Handlers.sqrtHandler(inputEx);
      case "help": Handlers.helpHandler(inputEx);
      case "exit": Handlers.exitHandler();
      case "quit": Handlers.exitHandler();
      default: out.println(" Command not supported!"); InputHandler.getEx();
    }
  }
}
