import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Пишем первый юнит тест.
 * 1. Если работаем с Gradle, то зависимость добавлена автоматически (testImplementation 'org.junit.jupiter:junit-jupiter')
 * Если работаем с Maven - зависимость нужно добавить в ручную
 * 2. Создаём тестовый класс и метод с аннотацией @Test
 * 3. Импортируем аннотацию @Test
 * 4. Реализуем тело тестового метода
 * 5. Используем Assertions для проверки ожидаемых результатов
 */

class FirstJUnitTests {

    @Test
    void SumNumbersTest() {

        // AAA: Arrange -> Act -> Assert (между ними пустая строка для визуализации)

        // Предусловие - создаём пользователя, переменные и тд (не всегда есть)
        int a = 3;
        int b = 2;

        // Действие (Act)
        int actualSum = a + b;
        int expectedSum = 5;

        // Assert
        assertEquals(expectedSum, actualSum);

    }

}