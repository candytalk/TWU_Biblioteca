package com.twu.biblioteca;

import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IOToolsTest {

    @Test
    public void test_sysout_and_sys_out_reset() throws Exception {
        IOTools.setSysOutToFile();
        System.out.print("intext");
        IOTools.resetSysOut();
        System.out.println("inscreen");


        Scanner scanner = IOTools.createScannerFromFile("out.txt");
        String stringFromScanner = scanner.next();
        assertThat(stringFromScanner, is("intext"));

    }
}
