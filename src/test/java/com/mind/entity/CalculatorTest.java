package com.mind.entity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static Stream<Arguments> values() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
        );
    }

    @Test
    @DisplayName("assertEquals")
    public void shouldSumValues() {
        Calculator calculator = new Calculator();
        Integer result = calculator.sum(2, 2);
        assertEquals(4, result, 0);
    }

    @Test
    @DisplayName("assertAll")
    public void shouldSumValues2() {
        Calculator calculator = new Calculator();

        assertAll("Test failed",
                () -> assertEquals(calculator.sum(2, 2), 4),
                () -> assertEquals(calculator.sum(3, 3), 6));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "2,1"})
    @DisplayName("ParameterizedTest - CvsSource")
    public void shouldSumValues3(int firstOperator, int secondOperator) {
        Calculator calculator = new Calculator();
        Integer result = calculator.sum(firstOperator, secondOperator);

        assertAll("Test failed",
                () -> assertEquals(result, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("ParameterizedTest - ValueSource")
    public void shouldAddValue(int value) {
        Calculator calculator = new Calculator();
        calculator.addValue(value);

        assertAll("Test failed",
                () -> assertEquals(calculator.getValue(), value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4})
    @DisplayName("ParameterizedTest - Exception")
    public void shouldThrowException_WhenAddNegativeNumbers(int value) {
        Calculator calculator = new Calculator();

        assertThatExceptionOfType(NegativeNumberException.class)
                .isThrownBy(() -> calculator.addValue(value));
    }

    @ParameterizedTest
    @MethodSource("values")
    public void shouldAddValue2(int value) {
        Calculator calculator = new Calculator();
        calculator.addValue(value);

        assertAll("Test failed",
                () -> assertEquals(calculator.getValue(), value));
    }

    @ParameterizedTest
    @CsvSource({"1,2", "3,1"})
    public void shouldSumTwoValues(int firstOperator, int secondOperator) {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(firstOperator, secondOperator))
                .isEqualTo(firstOperator + secondOperator);

        assertThat(calculator.sum(firstOperator, secondOperator))
                .isPositive();
    }

}
