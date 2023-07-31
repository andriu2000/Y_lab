package Lesson_2.Sequences;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SequencesTest {
public static void main(String[] args) throws IOException{
    int n=7;
    char i;
    boolean t = true;
    while (t) {
        System.out.print("Введите целое положительное число, >0 : ");
        Scanner k = new Scanner(System.in);
        n=-1;
        try {
            n = k.nextInt();
        } catch (InputMismatchException e) {}
        if (n>=1) t=false;
   }
    SequencesImpl Sequences_1 = new SequencesImpl();
        Sequences_1.a(n);
        Sequences_1.b(n);
        Sequences_1.c(n);
        Sequences_1.d(n);
        Sequences_1.e(n);
        Sequences_1.f(n);
        Sequences_1.g(n);
        Sequences_1.h(n);
        Sequences_1.i(n);
        Sequences_1.j(n);

}
}
