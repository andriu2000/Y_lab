package Lesson_1;

import org.w3c.dom.xpath.XPathNamespace;

import java.util.Scanner;

public class Pell {
    public static void main(String[] args) throws Exception {
        System.out.print("Введите число n: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            // System.out.println(" " +n+"  ");
            int p_n_1 = 1;
            int p_n_2 = 0;
            int pn =0;
            if (n == 0) {
                pn = 0;
            } else if (n == 1) {
                pn = p_n_1;
            } else if (n > 1) {
                for (int i = 2; i <= n; i++) {
                    pn = 2*p_n_1 + p_n_2;
                    p_n_2 = p_n_1;
                    p_n_1 = pn;
                }
           }
            System.out.println("Число Пелля:  " + pn);

        }

    }
}
