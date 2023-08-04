package Lesson_3.Transliterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TransliteratorImp implements Transliterator {
    public String transliterate(String sourse){
        HashMap<String,String> Translit_Map = new HashMap<>();
        String simvol_ru_str;
        String translit;
        String string_temp;
        char temp_char;
        int str_lenght;
        int translite_length;
        //string_temp = char_ru_temp.;
        //Translit_Map.put(char_ru_temp, )

       //------------------ загружаем файл транслитерации------------------------
        File filetxt = new File("E://","translit.txt");
        try(FileInputStream file = new FileInputStream(filetxt) ){
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                string_temp = scanner.nextLine();
                simvol_ru_str = String.valueOf(string_temp.charAt(0));
                str_lenght = string_temp.length();
                translit = string_temp.substring(2,str_lenght);
                Translit_Map.put(simvol_ru_str,translit);
            }

//            for (Map.Entry<String, String> karta: Translit_Map.entrySet()){
//                    System.out.println(karta.getKey()+",  "+karta.getValue());
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //-------------------------------------------------------------------
        // [А - 1040, Я - 1071], Ё - 1025


        str_lenght = sourse.length();
        string_temp="";
        simvol_ru_str="";

        System.out.println(simvol_ru_str);

        for (int i=0; i<str_lenght; i++){

            temp_char= sourse.charAt(i);
            if (sourse.charAt(i)== 'Ё'  | sourse.charAt(i)>='А' & sourse.charAt(i)<='Я' ) {
                simvol_ru_str = String.valueOf(sourse.charAt(i));
                string_temp = string_temp + Translit_Map.get(simvol_ru_str);
            }
            else string_temp = string_temp + String.valueOf(sourse.charAt(i));
        }

        return string_temp;

    }


}
