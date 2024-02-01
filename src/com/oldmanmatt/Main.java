package com.oldmanmatt;

public class Main {

    public static void main(String[] args) {
        while (true) {
            String command = Console.readInput("Write or Read? (W/R): ");
            switch (command.toLowerCase()) {
                case "w": {
                    String input = Console.readInput("Input: ");
                    System.out.println();
                    var codeCreator = new CodeCreator(input);
                    System.out.println(codeCreator.getCompleteCode());
                    System.out.println("--------------------");
                    break;
                }
                case "r": {
                    String input = Console.readInput("Input: ");
                    System.out.println();
                    var codeReader = new CodeReader(input);
                    System.out.println(codeReader.getDecodedMessage());
                    System.out.println("--------------------");
                    break;
                }
                case "quit":
                    break;
                default:
                    System.out.println("Invalid command.");
                    System.out.println("----------------");
                    break;
            }
        }
    }
}