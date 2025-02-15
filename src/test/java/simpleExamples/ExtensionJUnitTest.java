package simpleExamples;

import entities.User;
import extensions.LifecycleExtension;
import extensions.ParameterExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Пример использования созданных нами расширений. Сами extensions надодятся в папке extensions
 */

public class ExtensionJUnitTest {

    // На уровень теста или на уровень класса мы можем добавить аннотацию @ExtendWith, где мы подключаем наш созданный в папке extensions LifecycleExtension.class
    @ExtendWith(LifecycleExtension.class)
    @Test
    // Соответственно, должен сработать перед всеми тестами
    void JunitTestWithLifecycleExtend() {
        int actualSum = 1 + 1;
        int expectedSum = 2;
        assertEquals(expectedSum, actualSum);
        System.out.println("JunitTestWithExtend");
    }

    // А здесь, соответственно, подключаем наш созданный в папке extensions ParameterExtension.class
    @ExtendWith(ParameterExtension.class)
    @Test
    // Т.к. это не параметризованный тест, единственный способ передать сюда user - это расширение, что мы и делаем (потому что иначе тесту просто неоткуда эти данные взять)
    void JunitTestWithParameterExtend(User user) {
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30, user.getAge(),  "Неправильный возраст")
        );
    }

}
