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
    @Override
    public Employee parseStructure(File csvFile) throws IOException {

        List<Employee>  Employee_List = new ArrayList<>(); //список сотрудников

        String string = null;
        int string_lengf;

        try(FileInputStream file =new FileInputStream(csvFile)){
            Scanner scanner = new Scanner(file);

            //считываем первую строку
            if (scanner.hasNextLine())
                string=scanner.nextLine();

            // считываем остальные строки
            while (scanner.hasNextLine()){
                string=scanner.nextLine();
            }

        }

        return null;
    }
}
