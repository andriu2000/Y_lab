package Lesson_3.Org_Structure;

import java.io.File;
import java.io.IOException;

public class OrgStructureParserTest {
    static public void main(String[] args) throws IOException {
        File filecsv = new File(/*"D://",*/"orgStructure.csv");
        OrgStructureParserImp parser = new OrgStructureParserImp();

        parser.parseStructure(filecsv);
    }
}


