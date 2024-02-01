package com.oldmanmatt;

import java.util.Objects;

public class CodeReader {

    public String[] input;

    public CodeReader(String input) {
        this.input = input.split("(?<=\\G.{" + 3 + "})");
    }

    private String[] getKey() {
        String[] key = new String[CodeCreator.characters.length];
        System.arraycopy(input, 0, key, 0, CodeCreator.characters.length);
        return key;
    }

    public String[] getMessageCode() {
        String[] messageCode = new String[input.length - CodeCreator.characters.length];
        copyArray(input, CodeCreator.characters.length, messageCode, 0,
                messageCode.length);
        return messageCode;
    }

    public String getDecodedMessage() {
        char[] decodedArray = new char[getMessageCode().length];
        for (int j = 0; j < getMessageCode().length; j++) {
            int index = findIndex(getKey(), getMessageCode()[j]);
            decodedArray[j] = CodeCreator.characters[index];
        }
        return new String(decodedArray);
    }

    public static int findIndex(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], target))
                return i;
        }
        return -1;
    }

    private void copyArray(String[] readArray, int readArrayIndex, String[] writeArray, int writeArrayIndex, int length) {
        for (int i = 0; i < length; i++) {
            writeArray[writeArrayIndex + i] = readArray[readArrayIndex + i];
        }
    }
}