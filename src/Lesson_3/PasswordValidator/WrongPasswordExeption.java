package Lesson_3.PasswordValidator;

public class WrongPasswordExeption extends Exception{

    public  WrongPasswordExeption(){
    }
    public  WrongPasswordExeption(String message) {
        super(message);
    }
}
