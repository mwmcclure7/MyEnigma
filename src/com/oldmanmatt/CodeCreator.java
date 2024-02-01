package com.oldmanmatt;

import java.util.Objects;
import java.util.Random;

public class CodeCreator {

    public static final char[] characters = { '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '`',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', '{', '}', '|', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\', 'A', 'S', 'D', 'F',
            'G', 'H', 'J', 'K', 'L', ':', '"', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M', '<', '>', '?', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/', ' ' };

    private String[] sequences = new String[characters.length];
    private char[] inputArray;
    private String[] codeSequence;

    public CodeCreator(String input) {
        this.inputArray = input.toCharArray();
        this.codeSequence =  new String[input.toCharArray().length];
        keyCreator();
        codeGenerator();
    }

    private void keyCreator() {
        for (byte i = 0; i < characters.length;) {
            String currentSequence = randomSequenceGenerator();
            boolean isDubplicate = false;

            for (String element : sequences) {
                if (Objects.equals(element, currentSequence)) {
                    isDubplicate = true;
                    break;
                }
            }

            if (!isDubplicate) {
                sequences[i] = currentSequence;
                i++;
            }
        }
    }

    private String randomSequenceGenerator() {

        var random = new Random();
        char[] characters = {
                (char) (random.nextInt(24) + 'a'),
                (char) (random.nextInt(24) + 'a'),
                (char) (random.nextInt(24) + 'a') };

        return new String(characters);
    }

    private void codeGenerator() {

        for (int i = 0; i < inputArray.length; i++) {
            int characterIndex = findIndexString(inputArray[i]);
            codeSequence[i] = sequences[characterIndex];
        }
    }

    private String getKey() {
        return String.join("", sequences);
    }

    private String getCodeSequence() {
        return String.join("", codeSequence);
    }

    public String getCompleteCode() {
        return getKey() + getCodeSequence();
    }

    private static int findIndexString(char target) {
        for (int i = 0; i < CodeCreator.characters.length; i++) {
            if (Objects.equals(CodeCreator.characters[i], target))
                return i;
        }
        return -1;
    }
}
