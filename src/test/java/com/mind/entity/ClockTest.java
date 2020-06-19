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
    public void should_triggerTimeout() {
        Clock clock = new Clock();
        assertTimeout(Duration.ofMillis(1000), () -> clock.sleep(500));
    }

    @Test
    @DisplayName("assertTimeoutPreemptively")
    public void should_triggerTimeoutPreemptively() {
        Clock clock = new Clock();
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> clock.sleep(500));
    }

}
