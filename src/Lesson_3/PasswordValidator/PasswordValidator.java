package Lesson_3.PasswordValidator;

public class PasswordValidator {
    private  String login;
    //---------------------------- проверка логина----------------------------------------------
    public static boolean valid_Login(String login) throws WrongLoginExeption{
         int login_length;
        int temp_int=0;
        login_length = login.length();
        //----------------------- пустой логин-----------------------------------------
        if (login_length==0 ) throw new WrongLoginExeption("Пустой логин");

        if (login_length>20 ) throw new WrongLoginExeption("Логин слишком длинный");

        // ------------- проверяем на правильность символом "A-Z", "a-z", "0-9" и "_"---------------------------------
        for (int i=0; i<login_length;i++ )
            if ((login.charAt(i)>='0'&login.charAt(i)<='9') | (login.charAt(i)>='A')&(login.charAt(i)<='Z') | (login.charAt(i)>='a')&(login.charAt(i)<='z'))
                temp_int++;
        // Логин содержит недопустимые символы
        if (temp_int != login_length ) throw new WrongLoginExeption("Логин содержит недопустимые символы");

        return false;
    }
    //---------------------------- проверка пароля ----------------------------------------------
    public static boolean valid_Password(String password, String confimPassword) throws WrongPasswordExeption{

        int password_length;
        int temp_int=0;
        // обработаем один пароль на правильность, а потом сравним со вторым
        password_length = password.length();
        //----------------------- пустой пароль-----------------------------------------
        if (password_length ==0 ) throw new WrongPasswordExeption("Пустой пароль");

        if (password_length >20 ) throw new WrongPasswordExeption("Пароль слишком длинный");
        for (int i=0; i<password_length;i++ )
            if ((password.charAt(i)>='0'&password.charAt(i)<='9') | (password.charAt(i)>='A')&(password.charAt(i)<='Z') | (password.charAt(i)>='a')&(password.charAt(i)<='z'))
                temp_int++;
        // Пароль содержит недопустимые символы
        if (temp_int != password_length ) throw new WrongPasswordExeption("Пароль содержит недопустимые символы");

        if (! password.equals(confimPassword))  throw new WrongPasswordExeption("Пароль и подтверждение не совпадают");

        return false;
    }

    public static boolean passwordvalidator  (String login, String password, String confimPassword)  {

       try{ valid_Login(login);
           valid_Password(password, confimPassword);
           return true;
       }
       catch (WrongPasswordExeption | WrongLoginExeption e){
            e.printStackTrace();
            return false;
       }
    }
  }


