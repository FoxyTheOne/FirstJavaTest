package simpleExamples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс с примерами аннотаций подготовки и очистки в JUnit5.
 * Для того, чтобы эти аннотации работали (BeforeEach, AfterEach, BeforeAll, AfterAll), нам нужно добавить аннотации к классу,
 * а именно - @TestInstance(TestInstance.Lifecycle.PER_CLASS) и @TestMethodOrder(MethodOrderer.OrderAnnotation.class).
 * Без них не сработаетприоретизация тестов.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LifeCycleJUnitTest {

    @BeforeEach
        // Обычно это настройка перед тестами, поэтому метод назовем setUp
    void setUp() {
        // Здесь размещаем код подготовки перед каждым тестом
        System.out.println("Перед каждым тестом - BeforeEach");
    }

    @AfterEach
        // Обычно здесь мы уничтожаем ненужное после тестов, поэтому назовем метод tearDown
    void tearDown() {
        // Здесь размещаем код очистки после каждого теста
        System.out.println("После каждого теста - AfterEach");
    }

    @BeforeAll
    void setUpAll() {
        // Здесь размещаем код подготовки перед всеми тестами
        System.out.println("Перед всеми тестами - BeforeAll");
    }

    @AfterAll
    void tearDownAll() {
        // Здесь размещаем код очистки после всех тестов
        System.out.println("После всех тестов - AfterAll");
    }

    // И добавим ещё два теста для проверки

    @Test
    @DisplayName("Первый")
    @Order(1)
        // задали приоритет - @Order(1), но в обычной ситуации не факт, что этот порядок будет соблюдаться
    void firts() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
        System.out.println("Первый тест прошел");
    }

    @Test
    @DisplayName("Второй")
    void second() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
        System.out.println("Второй тест прошел");
    }

}
