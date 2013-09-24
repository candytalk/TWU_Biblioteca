package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class IOTools {
    static private PrintStream originalSysOut = new PrintStream(System.out);
    static private InputStream originalSysIn = System.in;

    public static void resetSysOut(){
        System.setOut(originalSysOut);
    }

    public static void resetSysIn(){
        System.setIn(originalSysIn);
    }

    public static void InputFromString(String inputString) {
        try {
            InputStream testInput = new ByteArrayInputStream(inputString.getBytes("UTF-8"));
            System.setIn(testInput);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setSysOutToFile() {
        setSysOutToFile("out.txt");
    }

    public static void setSysOutToFile(String path) {
        try {
            File file = new File(path);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setOut(printStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Scanner CreateScannerFromFile() {
        return createScannerFromFile("input.txt");
    }

    public static Scanner createScannerFromFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Scanner actual = new Scanner(fileInputStream);
            return actual;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
