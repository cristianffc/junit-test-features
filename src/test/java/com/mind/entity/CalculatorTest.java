package com.mind.entity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void setUp() {
        System.out.println("Set up");
    }

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

        assertAll("Test failed",
                () -> assertEquals(calculator.add(2, 2), 4),
                () -> assertEquals(calculator.add(3, 3), 6));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "2,1"})
    @DisplayName("Test two sum operations / ParameterizedTest/CvsSource")
    public void testTwoSumOperationsWithParameterizedTest(int firstOperator, int secondOperator) {
        Calculator calculator = new Calculator();
        Integer result = calculator.add(firstOperator, secondOperator);

        assertAll("Test failed",
                () -> assertEquals(result, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("Test add value / ParameterizedTest/Value")
    public void testAddValueWithParameterizedTest2(int value) {
        Calculator calculator = new Calculator();
        calculator.addValue(value);

        assertAll("Test failed",
                () -> assertEquals(calculator.getValue(), value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4})
    @DisplayName("Test add negative number exception / ParameterizedTest/Exception")
    public void testAddValueOperationWithException(int value) {
        Calculator calculator = new Calculator();

        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> calculator.addValue(value));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,1"})
    @DisplayName("Should sum two values")
    public void shouldSumTwoValues(int firstOperator, int secondOperator) {
        Calculator calculator = new Calculator();

        assertThat(calculator.add(firstOperator, secondOperator))
                .isEqualTo(firstOperator + secondOperator);

        assertThat(calculator.add(firstOperator, secondOperator))
                .isPositive();
    }
}
