package simpleExamples;

import org.junit.jupiter.api.Test;

/**
 * Класс для проверки параллельного запуска тестов в JUnit5
 */

public class ParallelJUnitTest {

    @Test
    void firstTest() throws Exception {
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    void secondTest() throws Exception {
        System.out.println("FirstParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() end => " + Thread.currentThread().getName());
    }

}
