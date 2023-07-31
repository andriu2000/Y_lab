package Lesson_2.StatsAccumulator;

public class StatsAccumulatorImp implements StatsAccumulator {
    private static int Min;   // Минимальный из всех элементов бщее кол-во элементов
    private static int Max;
    private static int Obsh_kol_el =0; // общее кол-во элементов
    private static double Sred_Arifm;

    @Override
    public void add(int value) {
        Obsh_kol_el++; // увеличиваем общее кол-во принятых элементов

                  // если это не первый элемент, пересчитываем показатели
        if (Obsh_kol_el >1) {
            if (value>Max) Max = value;  // если новое число меньше, чем сохраненнное минимальное, то обновляем Min
            if (value<Min) Min = value;  // если новое число больше, чем сохраненнное минимальное, то обновляем Max
            Sred_Arifm = (Sred_Arifm + value)/ 2;
        }
           else {  Min = value;
                   Max = value;
                   Sred_Arifm = value;
           }
    }

    @Override
    public int getMin() {
            return Min;
    }

    @Override
    public int getMax() {
        return Max;
    }

    @Override
    public int getCount() {
        return Obsh_kol_el;
    }

    @Override
    public double getAvr() {
        return Sred_Arifm;
    }
}
