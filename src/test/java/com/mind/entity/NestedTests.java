package com.mind.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedTests {
    private static final String name = "Hello";

    @Nested
    @DisplayName("Nested annotation test")
    class BuilderTest {
        @Test
        void nestedMethod() {
            assertEquals(name, "Hello");
        }
    }
}