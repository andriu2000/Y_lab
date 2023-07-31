package Lesson_2.SnilsValidator;



public class SnilsValidatorImpl implements SnilsValidator {

    //преобразуем число в строку, если преобразовать невозможно возвращаем "0"
    private long StrToInt(String s){
        int KolCifr=0;
        int n;
        long snilsInt=0;

        // проходимся по строке, формируем число, удаляя лишние знаки, кроме цифр '0' - '9'
        for(int i =0; i< s.length(); i++){
            if ((s.charAt(i)>= '0') & (s.charAt(i)<='9')) {
                KolCifr++;
                n= s.charAt(i)-48; // выделяем текущую цифру
                snilsInt = snilsInt*10+n; // формируем выходное число
            }
            if (KolCifr > 11) {  KolCifr=0; break;}

        }
         //System.out.println("Кол-во цифр: "+KolCifr);
         //System.out.println("Число после фильтрации: "+snilsInt);
        if (KolCifr==11) {
            //System.out.println("Это число правильное");
            return snilsInt;
        }
        else {
            System.out.println("Это не число, не содержит нужное число знаков, или число с ошибкой");
            return 0;
        }



    }
    @Override
    public boolean validate(String snils){
        long snilsInt; // полученный номер СНИЛС, если =0, значит число не соответствтует требованиям
        long Kontr_chislo_Raschet =0; // контрольная сумма вычесленная по номеру СНИЛС
        long Kontr_chislo_po_Snils; // контрольная сумма полученная из самого СНИЛС

        snilsInt=StrToInt(snils); //преобразуем число в строку
                    // если число = 0, преобразование неудачное,
                    // если есть число != 0 , с ним можно работать
        if (snilsInt==0) return false;
        else {
            Kontr_chislo_po_Snils = snilsInt % 100; // получаем контрольную сумму, указанную в СНИЛС
            //System.out.println( "Контрольная сумма по СНИЛС: "+ Kontr_chislo_po_Snils);
            snilsInt = snilsInt / 100;   // отсекаем контрольную сумму, получаем сам номер СНИЛС

            // ----------------------получаем сумму произведений---------------------
            for (int i = 1; i <= 11; i++) {
                Kontr_chislo_Raschet = Kontr_chislo_Raschet + (snilsInt % 10) * i;
                snilsInt = snilsInt / 10;
            }
            //System.out.println( "Сумма произведений "+ Kontr_chislo_Raschet);
            // ----------------------------работаем с суммой цифр--------------------------
            if (Kontr_chislo_Raschet < 100) {
            } // если сумма цифр < 100, ничего не делаем
            else if (Kontr_chislo_Raschet == 100) Kontr_chislo_Raschet = 0;   // если сумма = 100, обнуляем
            else if (Kontr_chislo_Raschet > 100) {     // если сумма > 100, получаем остаток от деления на 101
                Kontr_chislo_Raschet = Kontr_chislo_Raschet % 101;
                if (Kontr_chislo_Raschet == 100) {
                    Kontr_chislo_Raschet = 0;
                }  // если сумма = 100, обнуляем
            }
            //------------------------ сравниваем полученное число контрольной суммы с данным в самом СНИЛС ----------------------
            if (Kontr_chislo_Raschet == Kontr_chislo_po_Snils)
                return true;
            else
                return false;
        }
    }

}
