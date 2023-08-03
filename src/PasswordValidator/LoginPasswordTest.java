package PasswordValidator;

import java.util.Scanner;

import static PasswordValidator.PasswordValidator.passwordvalidator;

//import static PasswordValidator.PasswordValidator.passwordvalidator;
//import PasswordValidator;
public class LoginPasswordTest {
    public static void main(String args[]) {
        String login, password, confimpassword;
        Scanner str = new Scanner(System.in);

        System.out.print("   Введите логин :");
        login= str.nextLine();

        System.out.print("  Введите пароль :");
        password= str.nextLine();

        System.out.print("Повторите пароль :");
        confimpassword= str.nextLine();
        System.out.println("Результат проверки: "+passwordvalidator(login,password,confimpassword));

        //System.out.println("Результат проверки: "+passwordvalidator("dfg5757567567rt47","12","12_"));
    }

}
