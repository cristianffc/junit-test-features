package com.mind.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedTestsTest {
    private static final String name = "Test";

    @Nested
    @DisplayName("Nested annotation")
    class BuilderTest {
        @Test
        void nameTest() {
            assertEquals(name, "Test");
        }
    }
}