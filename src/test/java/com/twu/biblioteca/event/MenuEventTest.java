package com.twu.biblioteca.event;

import com.twu.biblioteca.IOTools;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.message.InvalidOrErrorMessage;
import com.twu.biblioteca.message.Message;
import com.twu.biblioteca.message.NullMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MenuEventTest {
    private Event menuEvent;

    @Before
    public void setUp() throws Exception {
        menuEvent = new MenuEvent();
    }
    @After
    public void tearDown() throws Exception {
        Library.reset();
    }

    @Test
    public void menu_should_can_response_incorrect_input() throws Exception {
        //when
        IOTools.InputFromString("4");
        menuEvent.execute();

        //then
        assertTrue(menuEvent.messageAfterExecute() instanceof InvalidOrErrorMessage);
        assertTrue(menuEvent.nextEvent() instanceof MenuEvent);
    }

    @Test
    public void menu_should_show_menu_message() throws Exception {
        IOTools.InputFromString("1");
        menuEvent.execute();
        Message msg = menuEvent.messageAfterExecute();
        assertTrue(msg instanceof NullMessage);
    }
}
