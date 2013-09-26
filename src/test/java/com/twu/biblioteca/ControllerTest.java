package com.twu.biblioteca;

import com.twu.biblioteca.event.Event;
import com.twu.biblioteca.event.ListBookEvent;
import com.twu.biblioteca.event.MenuEvent;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControllerTest {
    Controller iohandler = new Controller();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void iohandler_could_handle_correct_input() throws Exception {
        //set up
        Event menuEvent = new MenuEvent();
        iohandler = new Controller(menuEvent);

        //when input "1" under menuEvent
        IOTools.InputFromString("1");
        menuEvent.execute();

        //should redirect to list book Event
        assertTrue(menuEvent.nextEvent() instanceof ListBookEvent);
    }

    @Test
    public void iohandler_could_handle_incorrect_input() throws Exception {
        //set up
        Event menuEvent = new MenuEvent();
        iohandler = new Controller(menuEvent);

        //when input "1" under menuEvent
        IOTools.InputFromString("4");
        menuEvent.execute();

        //should redirect to itself because iohandler can't handle the wrong input
        assertTrue(menuEvent.nextEvent() instanceof MenuEvent);
        assertTrue(menuEvent.messageAfterExecute() instanceof InvalidOrErrorMessage);
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
