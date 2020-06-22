package com.mind.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Clock SUT class")
public class ClockTest {

    @Test
    @DisplayName("asserTimeout")
    public void shouldTriggerTimeoutWhenTimeIsOver() {
        Clock clock = new Clock();
        assertTimeout(Duration.ofMillis(1000), () -> clock.sleep(500));
    }

    @Test
    @DisplayName("assertTimeoutPreemptively")
    public void shouldTriggerTimeoutPreemptivelyWhenTimeIsOver() {
        Clock clock = new Clock();
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> clock.sleep(500));
    }

}
