package Lesson_3.PasswordValidator;

class WrongLoginExeption extends Exception{
    public  WrongLoginExeption(){
    }
    public WrongLoginExeption(String message){
        super(message);
    }
}