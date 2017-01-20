package ru.livetex.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({
        RoomTest.class, EventListenerTest.class
})

public class Runner {
}