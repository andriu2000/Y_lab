package Lesson_3.Org_Structure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrgStructureParserTest {
    static public void main(String[] args) throws IOException {

        File filecsv = new File("E://","orgStructure.csv");
        OrgStructureParserImp parser = new OrgStructureParserImp();
        Employee gen_director = new Employee();
        gen_director= parser.parseStructure(filecsv);
        if (gen_director !=null )
            System.out.print("Генеральный директор::  имя: "+gen_director.getName()+ ", должность: "+gen_director.getPosition() +" id: "+gen_director.getId()+ ", boss_id: "+gen_director.getBossId()+ ", ");
         else System.out.println(" Нет должности с boss_id = null");

    }
}


