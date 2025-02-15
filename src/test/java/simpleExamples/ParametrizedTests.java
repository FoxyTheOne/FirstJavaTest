package simpleExamples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс с примерами параметризованных тестов в JUnit5
 */

public class ParametrizedTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
        // При ошибке, сколько запусков, столько будет записей с падениями.
        // В данном случае запуска три - ints = {1, 2, 3}
    void sourceTest(int parameter) {
        int actualSum = parameter + parameter;
        int expectedSum = 2 * parameter;

        assertEquals(expectedSum, actualSum, "Суммы должны быть разными");
    }

    @ParameterizedTest
    @CsvSource({"John, Doe", "Alice, Smith"})
        // Передаем по несколько параметров. В нашем случае проверяем на имя фамилию. Или можно например исползовать это как actual + expected value
    void csvTest(String firstName, String lastName) {
        List<String> expectedPeople = Arrays.asList("John Doe1", "Alice Smith");

        assertTrue(expectedPeople.contains(firstName + " " + lastName));
    }

    static Stream<String> provideParameters() {
        return Stream.of("One", "Two", "Three");
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
        // Передаём параметры из внешнего метода (provideParameters())
        // В @MethodSource мы указываем название используемого метода в "" и метод у нас возвращает либо stream, либо iterable
    void customParametersTest(String parameter) {
        List<String> expectedList = Arrays.asList("one", "two", "three");

        assertTrue(expectedList.contains(parameter.toLowerCase(Locale.ROOT)));
    }

}
