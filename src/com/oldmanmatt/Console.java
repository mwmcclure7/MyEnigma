package com.oldmanmatt;

import java.util.Scanner;

public class Console {

    public static String readInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
