package Lesson_3.Org_Structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrgStructureParserImp implements OrgStructureParser {

     private static void parser_str(String str){

     }
     private void zagruzka(List Employee){

     }
    @Override
    public Employee parseStructure(File csvFile) throws IOException {

        List<Employee>  Employee_List = new ArrayList<>(); //список сотрудников

        Employee one_employee= new Employee(); // один сотрудник

        String string = null;
        int string_lengf;
        int kol_simv_do_razdelitelya;
        int index_start; // индекс в строке с какого начнем копировать
        int index_stop;  // индекс в строке до которого будем копировать
        int nomer_parametra;
        int temp_int =0;
        String temp_str;
        try(FileInputStream file =new FileInputStream(csvFile)){
            Scanner scanner = new Scanner(file);

            //считываем первую строку
            if (scanner.hasNextLine())
                string=scanner.nextLine();

            // считываем остальные строки
            while (scanner.hasNextLine()){
                string=scanner.nextLine();
                string_lengf= string.length(); // считываем очередную строку
                index_start =0;
                index_stop = 0;
                nomer_parametra = 1;
                //while ()
                //kol_simv_do_razdelitelya=0; // считаем количество символов до очередного разделителя

                while (index_start<string_lengf) {
                    //for (nomer_parametra=1; nomer_parametra<=4; nomer_parametra++){

                        //System.out.println("Запуск");
                     /* do   {index_stop++; }
                          while ((string.charAt(index_stop) != ';')&(index_stop<string_lengf));*/
                    while ((index_stop<string_lengf) && (string.charAt(index_stop) != ';')) index_stop++; // ищем очередной разделитель или последний символ строки

                    //
                        if (index_stop==index_start)  {temp_str = null; }
                            else  temp_str = string.substring(index_start, index_stop); // копируем символы для параметра



                   // System.out.print(" |"+temp_str+"|  ");
                    // System.out.println(" index_start= "+index_start+",   index_stop= "+index_stop+",   string_lengf= "+string_lengf+ ",  nomer_parametra= "+ nomer_parametra);
                    // в завистимости от номера параметра обрабатываем полученные символы
                    switch (nomer_parametra) {
                        case 1:  //  добавляем id к сотруднику
                            if (temp_str != null) {  // если число не равно null пытаемся его ковертировать
                                try {
                                    temp_int = Integer.parseInt(temp_str.trim());
                                    one_employee.setId((long) temp_int);
                                }
                                catch (NumberFormatException nfe)  // если ошибка формата записываем null
                                {
                                    one_employee.setId(null);
                                }
                            }
                            else    one_employee.setId(null);
                            break;

                        case 2:
                            if (temp_str != null) {  // если число не равно null пытаемся его ковертировать
                                try {
                                    temp_int = Integer.parseInt(temp_str.trim());
                                    one_employee.setBossId((long) temp_int);
                                    }
                                catch (NumberFormatException nfe)  // если ошибка формата записываем null
                                {
                                    one_employee.setBossId(null);
                                }
                            }
                            else    one_employee.setBossId(null);
                            break;

                        case 3:
                            one_employee.setName(temp_str);
                            break;
                        case 4:
                            one_employee.setPosition(temp_str);
                            break;
                    }

                    index_stop++;
                    index_start = index_stop;
                    nomer_parametra++;
                }
                //---------------------------------- закончили строку обрабатывать

                System.out.println("Id: "+one_employee.getId()+", boss_id: "+one_employee.getBossId()+", name: "+one_employee.getName()+", possition: " +one_employee.getPosition());
            }
        //----------------------------------------------------------------------------
        }

        return null;
    }
}
