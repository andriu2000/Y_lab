package Lesson_3.Org_Structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrgStructureParserImp implements OrgStructureParser {



     //private void zagruzka(List Employee){

    private List<Employee>  zagruzka_info_from_file(File csvFile)throws IOException{

         List<Employee>  Employee_List = new ArrayList<>(); //список сотрудников

         // Employee one_employee= new Employee(); // один сотрудник

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
                 index_start =0;  // индекс начала обрабатываемого поля из строки файла
                 index_stop = 0;  // индекс конца обрабатываемого поля из строки файла
                 nomer_parametra = 1; // отвечает за поле класса, которое будем заполнять
                 Employee one_employee= new Employee(); // один сотрудник

                 while (index_start<string_lengf) {
                     while ((index_stop<string_lengf) && (string.charAt(index_stop) != ';')) index_stop++; // ищем очередной разделитель или последний символ строки

                     if (index_stop==index_start)  {temp_str = null; } // если индексы равны, значит это ";;" и ифнормации нету
                                // если индексы разные, значит есть хотя бы один символ, который можно обработать
                     else  temp_str = string.substring(index_start, index_stop); //  копируем символы для параметра

                     // System.out.println(" index_start= "+index_start+",   index_stop= "+index_stop+",   string_lengf= "+string_lengf+ ",  nomer_parametra= "+ nomer_parametra);

                     switch (nomer_parametra) {   // в завистимости от номера параметра обрабатываем полученные символы
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
                         case 2:   // добавляем id начальника к сотруднику
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

                         case 3:   // добавляем имя сотрудника
                             one_employee.setName(temp_str);
                             break;
                         case 4:      // добавляем должность сотрудника
                             one_employee.setPosition(temp_str);
                             break;
                     }

                     index_stop++;
                     index_start = index_stop;
                     nomer_parametra++;
                 }
                 //---------------------------------- закончили строку обрабатывать

                 //System.out.println("Id: "+one_employee.getId()+", boss_id: "+one_employee.getBossId()+", name: "+one_employee.getName()+", possition: " +one_employee.getPosition());
                 boolean add = Employee_List.add(one_employee);
                 one_employee =null;
             }
             //----------------------------------------------------------------------------
         }
         return Employee_List;
     }
    // ====================== формируем информацию о начальниках у сотрудниках ========================
     private void Employee_set_boss(List<Employee> Employee_List ){
        Long temp_long;
        int Employee_List_size = Employee_List.size();           // определяем общее кол-во эл. в списке
         for (int i = 0; i < Employee_List_size; i++) {                // проходимся по списку
             temp_long = Employee_List.get(i).getBossId();       // получаем номер начальника
             if (temp_long != null) {                              // если у сотрудника есть начальник, формируем о нем данные
                 Employee Employee_temp = Employee_List.get(i); // создаем копию ссылки сотрудника
                 Employee_temp.setBoss(Employee_List.get(temp_long.intValue() - 1)); // изменяем по ссылке информацию о начальнике
             }
         }
     }
    // ===================== формируем список подчиненных ===============================
     private void Employee_set_subordinate(List<Employee> Employee_List){
         // перебираем все boss_id по очереди и каждом проходе запоминаем сотрудников, у которых одинаковый boss_id
        int Employee_List_size = Employee_List.size();

         for (int i = 0; i < Employee_List_size; i++) { // выбираем очередной id из списка номеров id сотрудников
             List<Employee> Subordinate_List = new ArrayList<Employee>();  // создаем новый лист подчиненных

             for (int j = 0; j < Employee_List_size; j++) { // проходимся по списку , ищем сотрудников у которых BossId = очередному номеру
                 try {                                                       // если есть такой сотрудник добавляем его в коллекцию
                     if (Employee_List.get(j).getBossId().intValue() ==(i+1) ) Subordinate_List.add(Employee_List.get(j));
                 } catch (NullPointerException e) {}
             }
             if (Subordinate_List.size() > 0) { // если в колекции есть элементы, добавляем эту коллекцию в список подчиненных
                 Employee_List.get(i).setSubordinate(Subordinate_List);
             }
             else Employee_List.get(i).setSubordinate(null);

             Subordinate_List = null;
         }
     }
    @Override
    public Employee parseStructure(File csvFile) throws IOException {

        List<Employee> Employee_List = new ArrayList<>(); //список сотрудников


        Employee_List = zagruzka_info_from_file(csvFile);  // загружаем с файла информацию о сотрудниках

        Employee_set_boss(Employee_List);   // устанавливаем начальников у подчиненных
        Employee_set_subordinate(Employee_List); // устанавливаем подчиненных у начальников
       //Long temp_long; // для врменного хранения
        //int temp_int; // для временного хранения


//        //------------------- выводим информацию о начальниках -----------------
//        int Employee_List_size = Employee_List.size();
//        for (int i = 0; i < Employee_List_size; i++) {
//            if (Employee_List.get(i).getBossId() != null)
//                System.out.println("У " + Employee_List.get(i).getName() + " начальник " + Employee_List.get(i).getBoss().getName());
//        }
//      //------------------- выводим информацию о подчиненных -----------------------------
//        for (Employee employee: Employee_List  ){
//            try {
//                if (employee.getSubordinate()!=null) {
//                    int m = employee.getSubordinate().size();
//                        System.out.print("У сотрудника "+employee.getName()+" подчиненные: ");
//                        for(Employee subordinate: employee.getSubordinate()){
//                            System.out.print(subordinate.getName()+ ", ");
//                        }
//                        System.out.println();
//                        //System.out.println(employee.getSubordinate());
//                }
//
//            } catch (NullPointerException e) {}
//        }
        //----------------------------------------------------------------------
       for (Employee employee: Employee_List){
           try{
               if (employee.getBossId()==null) return employee;

           } catch (NullPointerException e) {}

       }
         return null;
    }
}
