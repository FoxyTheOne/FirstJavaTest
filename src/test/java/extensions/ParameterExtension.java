package extensions;

import entities.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * Ещё один пример расширений в JUnit5.
 * Мы будем передавать параметр. Для того чтобы это сделать, нужно реализовать интерфейс ParameterResolver.
 * <p>
 * Resolver-ы могут использоваться для каких-то генераций на основе например баз данных.
 * Т.е. нам нужно сгенерировать какого-то тестового пользователя только в те методы, где мы его используем.
 * Пример использования наших расширений - в классе ExtensionJUnitTest.
 */

public class ParameterExtension implements ParameterResolver {

    // Проверка того, что мы можем этот параметр использовать (тип данных, который мы передаём, валидный)
    // Например, мы записали тип User.class. Если передаётся любой другой тип данных, он не будет соответствовать нашему текущему типу данных
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(User.class);
    }

    // И сам Resolver, который возвращает нам, например, какой-то заготовленный объект
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        // Здесь стоит передавать какого-то сгенерированного пользователя из базы данных, а не хард код
        return new User("John", "Doe", 30);
    }
}
