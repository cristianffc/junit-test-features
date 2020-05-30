package com.mind.entity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Calculator test class")
public class CalculatorTest { //It can be package-private

    @BeforeAll
    public void setUpClass() {
        System.out.println("Set up Calculator test");
    }

    @AfterAll
    public void tearDownClass() {
        System.out.println("Tear down Calculator test");
    }

    @BeforeEach
    public void setUp() { System.out.println("Set up"); }

    @AfterEach
    public void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    @DisplayName("Add method test / assertEquals")
    public void testSum() {
        Calculator calculator = new Calculator();
        Integer result = calculator.add(2, 2);
        assertEquals(4, result, 0);
    }

    @Test
    @DisplayName("Test two sum operations / assertAll")
    public void testTwoSumOperations() {
        Calculator calculator = new Calculator();
        Integer result = calculator.add(2, 2);

        assertAll("Test failed",
                () -> assertEquals(calculator.add(2,2), 4),
                () -> assertEquals(calculator.add(3,3), 6));
    }
}
