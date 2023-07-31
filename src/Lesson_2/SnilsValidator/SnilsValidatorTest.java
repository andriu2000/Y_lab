package Lesson_2.SnilsValidator;

import java.util.Scanner;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        SnilsValidatorImpl snils = new SnilsValidatorImpl();
       //  правильный СНИЛС 90114404441 , 112-233-445 95
       // ввод номера
        System.out.print("Введите СНИЛС (допускаются пробелы и др. символы, важно, чтобы было 11 цифр): ");
        Scanner scanner = new Scanner(System.in);

       // проверка СНИЛС
         if (snils.validate(scanner.nextLine()) ) System.out.println( "это правильный СНИЛС");
             else System.out.println( "это НЕ правильный СНИЛС");

        //System.out.println(new SnilsValidatorImpl().validate("112-233-445 95") );
    }
}
