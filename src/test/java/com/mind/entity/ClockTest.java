package com.mind.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Clock test class")
public class ClockTest {

    @Test
    @DisplayName("Sleep method test / asserTimeout")
    public void testSleep1() {
        Clock clock = new Clock();
        assertTimeout(Duration.ofMillis(1000), () -> clock.sleep(10000));
    }

    @Test
    @DisplayName("Sleep method test / assertTimeoutPreemptively")
    public void testSleep2() {
        Clock clock = new Clock();
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> clock.sleep(10000));
    }

}
