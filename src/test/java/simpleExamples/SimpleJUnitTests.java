package simpleExamples;

import entities.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс с примерами базовых аннотаций JUnit5 и основными Assertions
 * Для создания объекта используем созданный нами в этом проекте класс User
 */

class SimpleJUnitTests {

    // Примеры базовых аннотаций JUnit5

    @Test
    void simpleJUnitTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Disabled
        // Тест не будет запущен, в отчет попадет как ignored
    void disabledTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
        System.out.println("Disabled test");
    }

    @Test
    @DisplayName("Сложение двух чисел")
        // DisplayName позволяет задать название тесту, которое будет отображаться в отчетах
    void titleTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Tag("smoke")
        // Tag группирует тесты по тегам
    void tagTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum, "Суммы должны быть разными");
    }

    @Test
    @Tags({@Tag("defect"), @Tag("smoke")})
    @Timeout(value = 2)
        // Пример использования нескольких тегов, а так же тега Timeout (ограничение времени выполнения теста)
        // Этот тест должен выполниться за 2 секунды, иначе выпадет исключение
    void timeoutTest() throws InterruptedException {
        Thread.sleep(2000);

        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
    }

    @RepeatedTest(value = 3, name = "{displayName} - повторение {currentRepetition} из {totalRepetitions}")
    @DisplayName("Сложение двух чисел")
        // RepeatedTest запускает тест несколько раз. {displayName} - это как переменная, поэтому нам нужно задать @DisplayName
    void repeatedTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertEquals(expectedSum, actualSum);
    }

    // Примеры assertions

    @Test
    void assertTrueFalseTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;

        assertTrue(expectedSum == actualSum); // результатом будет boolean
        assertFalse(expectedSum != actualSum);
    }

    @Test
    void exceptionTest() {
        String test = null;

        Exception thrown = assertThrows(NullPointerException.class, () -> test.length());
        // Первое - какой класс-исключение мы ожидаем - "NullPointerException.class"
        // Второе - с помощью лямбда выражения мы вызываем метод length() - "() -> test.length()"

        // Можем проверить текст нашего исключения:
        Assertions.assertEquals("Cannot invoke \"String.length()\" because \"test\" is null", thrown.getMessage());
    }
    // ^Тест работает не правильно. NullPointerException есть, но thrown.getMessage() = null. Возможно связано с версией Java

    @Test
    void assertsAllTest() {
        // Создаём объект нужного имеющегося класса для дальнейшей проверки его полей
        User user = new User("John", "Doe", 30);

        // assertAll позволяет пройти все проверки, даже если где-то выпадет исключение, и затем выдать полный результат по всем заданным проверкам.
        // Можем проверить каждое поле по отдельности.
        // Пишем, что имя должно быть "John" (expected), затем узнаём, какое имя мы имеем на самом деле "user.getFirstName()", и дописываем сообщение, которое хотим получить, если проверка упадет
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30, user.getAge(), "Неправильный возраст")
        );
    }

    @Test
        // Пример таких же проверок, но последовательных, а не параллельных
    void AssertAllSeparate() {
        User user = new User("John", "Doe", 30);

        assertEquals("John1", user.getFirstName(), "Неправильное имя");
        assertEquals("Doe2", user.getLastName(), "Неправильная фамилия");
        assertEquals(31, user.getAge(), "Неправильный возраст");
    }

    @Test
    void first() throws Exception {
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    void second() throws Exception {
        System.out.println("FirstParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() end => " + Thread.currentThread().getName());
    }

}
