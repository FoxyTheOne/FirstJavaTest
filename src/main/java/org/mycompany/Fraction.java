package org.mycompany;

import java.util.Objects;

/**
 * Задача (скопировано у преподавателя, я считаю нужно доработать момент, когда оба знаменателя одинаковы)
 * Создать класс для дробных чисел, который работает с дробными числами не как с десятичной дробью, а как с числом, у которого есть числитель и знаменатель.
 * Нужно иметь возможность создавать и пока что реализовать только одну операцию - это сумма двух дробных чисел:
 * 1/2 + 3/2 = 4/2
 */

public class Fraction {

    // Можно использовать int, будет даже лучше, но мы сделали так, поэтому нужна ещё проверка на 0
    // Числитель и знаменатель:
    Integer num;
    Integer den;

    // Getters and setters
    // Поля не приватные, но и не публичные, поэтому в тестах нам будет их сложно получить, поэтому пишет геттеры
    public Integer getNum() {
        return num;
    }

    public Integer getDen() {
        return den;
    }

    // Конструктор с проверками
    public Fraction(Integer num, Integer den) {
        if (num == null || den == null) {
            // Числитель и знаменатель не должны быть пустыми
            throw new NullPointerException("Values should be not null");
        }
        if (den == 0) {
            // Знаменатель не должен быть равен нулю
            throw new ArithmeticException("Cannot divide to zero");
        }
        // если проверки пройдены - создаём наш объект
        this.num = num;
        this.den = den;
    }

    public static Fraction sum(Fraction first, Fraction second) {
        // Перемножаем наши знаменатели и должны соответствующим образом перемножить и наши числители.
        // Но в ходе нашего перемножения мы можем выйти за границы int. Поэтому мы проверяем для начала с помощью long
        long bigCommonDen = ((long) first.getDen() * (long) second.getDen());
        if (bigCommonDen > Integer.MAX_VALUE) {
            throw new RuntimeException("Common denominator is too big!");
        }
        // Правило сложения дробей с разными знаменателями:
        // Умножить числитель и знаменатель каждой дроби на дополнительный множитель и сложить дроби с одинаковыми знаменателями
        Integer commonDen = first.getDen() * second.getDen();
        Integer sumNum = first.getNum() * second.getDen() + second.getNum() * first.getDen();
        return new Fraction(sumNum, commonDen);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return Objects.equals(num, fraction.num) && Objects.equals(den, fraction.den);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }

    // Что здесь тестировать? Начнём с позитивных проверок и пойдём дальше
    // 1/2 + 2/3 = 7/6 -> позитивный тест
    // -1/2 + 2/3 = 1/6 -> позитивный тест
    // Так же проверить с отрицательным результатом
    // -1/3 + 1/3 = -1/6 -> позитивный тест
    // -1/2 + 1/2 = 0/4 -> позитивный тест ----- мой комментарий: в классе нужна проверка на одинаковый знаменатель, потому что здесь ответ будет 0/2. Когда знаменатели одинаковый, мы не перемножаем, а просто складываем числители

    // Негативные тесты:
    // (Ищем наши if и их обрабатываем)
    // null/2 + null/3 -> "Values should be not null"
    // 1/0 + 2/3 -> "Cannot divide to zero"
    // Integer.MAX_VALUE / 2 + 1/2 = Integer.MIN_VALUE - "Common denominator is too big!"

}
