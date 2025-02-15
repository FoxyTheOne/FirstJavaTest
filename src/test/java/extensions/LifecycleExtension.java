package extensions;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * Пример расширений в JUnit5.
 * Если мы хотим вклиниться в жизненный цикл, мы должны создать новый класс и реализовать один из вариантов extension,
 * в данном случае - BeforeTestExecutionCallback. Это значит, что мы будем вклиниваться до самого теста.
 * Пример использования наших расширений - в классе ExtensionJUnitTest.
 */

public class LifecycleExtension implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        // Здесь реализовываем нашу идею
        System.out.println("Extension execution");
    }
}
