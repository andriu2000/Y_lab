package Lesson_2.StatsAccumulator;

public interface StatsAccumulator {
    // добовляет число в аккумулятор
    void add(int value);

    // возврщащает минимальное из всех чисел
    int getMin();

    // возврщащает максимальное из всех чисел
    int getMax();

    // возврщащает количество всех добавленных чисел
    int getCount();

    // возврщащает среднее арифметическое всех добавленных чисел
    double getAvr();
}
