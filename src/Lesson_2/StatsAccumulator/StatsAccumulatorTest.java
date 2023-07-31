package Lesson_2.StatsAccumulator;

import java.util.Scanner;

public class StatsAccumulatorTest {

    public static void main(String[] args) {


        System.out.println("Завершение работы программы - любой набор символов, который не является числом ");

        boolean rabota = true;
        int KolCifr;
        int n; // переменная для временного хранения выделяемой цифры
        int value;
        String str;
        StatsAccumulatorImp s = new StatsAccumulatorImp();
        Scanner scanner = new Scanner(System.in);
        while (rabota) {
            System.out.print("Введите число: ");
            str = scanner.nextLine();
            KolCifr = 0;
            value = 0;
            // проходимся по строке, формируем число

            for (int i = 0; i < str.length(); i++)
                if ((str.charAt(i) >= '0') & (str.charAt(i) <= '9')) {
                    KolCifr++;
                    n = str.charAt(i) - 48; // выделяем текущую цифру
                    value = value * 10 + n; // формируем выходное число
                }

            if ((KolCifr != str.length())|(str.length() == 0)) rabota = false; // если ввели не число, заканчиваем работу
                // если ввели число добавляем его
            else {
                s.add(value);
                System.out.println("Counter : " + s.getCount());
                System.out.println("    Min : " + s.getMin());
                System.out.println("    Max : " + s.getMax());
                System.out.println("    Avr : " + s.getAvr());
                System.out.println("---------------------------------");


            }

            //break;
        }
    }
        }


