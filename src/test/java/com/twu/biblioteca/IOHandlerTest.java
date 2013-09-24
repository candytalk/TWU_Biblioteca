package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IOHandlerTest {
    IOHandler iohandler = new IOHandler();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getKeyboardInput() throws Exception {
        //given system.in from string
        IOTools.InputFromString("test");
        iohandler.scanInput();
        IOTools.resetSysIn();

        //then
        assertEquals(iohandler.returnInput(), "test");

    }
}
