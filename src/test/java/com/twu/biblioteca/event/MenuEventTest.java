package com.twu.biblioteca.event;

import com.twu.biblioteca.message.MenuMessage;
import com.twu.biblioteca.message.Message;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MenuEventTest {
    private Event menuEvent;

    @Before
    public void setUp() throws Exception {
        menuEvent = new MenuEvent();

    }

    @Test
    public void menu_should_show_menu_message() throws Exception {

        Message msg = menuEvent.messageBeforeExecute();

        assertTrue(msg instanceof MenuMessage);
    }
}
