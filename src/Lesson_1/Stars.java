package Lesson_1;

import java.util.Scanner;

public class Stars {
 public static void main(String[] args) throws Exception{
     System.out.print("Введите размер массива и введите символ для заполнения массива: ");
     try (Scanner scanner = new Scanner(System.in)){
         int n = scanner.nextInt();
         int m = scanner.nextInt();
         String template = scanner.next();
         for(int i=0; i<n; i++) {
             for (int j = 0; j < m; j++)
                 System.out.print(template+ " ");
            System.out.println("");
         }
     }
 }
}
