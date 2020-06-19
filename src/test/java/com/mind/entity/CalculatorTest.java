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
@DisplayName("Calculator SUT class")
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
    @DisplayName("assertEquals")
    public void should_sumValues() {
        Calculator calculator = new Calculator();
        Integer result = calculator.sum(2, 2);
        assertEquals(4, result, 0);
    }

    @Test
    @DisplayName("assertAll")
    public void should_sumValues2() {
        Calculator calculator = new Calculator();

        assertAll("Test failed",
                () -> assertEquals(calculator.sum(2, 2), 4),
                () -> assertEquals(calculator.sum(3, 3), 6));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "2,1"})
    @DisplayName("ParameterizedTest - CvsSource")
    public void should_sumValues3(int firstOperator, int secondOperator) {
        Calculator calculator = new Calculator();
        Integer result = calculator.sum(firstOperator, secondOperator);

        assertAll("Test failed",
                () -> assertEquals(result, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("ParameterizedTest - ValueSource")
    public void should_addValue(int value) {
        Calculator calculator = new Calculator();
        calculator.addValue(value);

        assertAll("Test failed",
                () -> assertEquals(calculator.getValue(), value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4})
    @DisplayName("ParameterizedTest - Exception")
    public void should_throwException_when_addNegativeNumbers(int value) {
        Calculator calculator = new Calculator();

        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> calculator.addValue(value));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,1"})
    public void should_sumTwoValues(int firstOperator, int secondOperator) {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(firstOperator, secondOperator))
                .isEqualTo(firstOperator + secondOperator);

        assertThat(calculator.sum(firstOperator, secondOperator))
                .isPositive();
    }
}
