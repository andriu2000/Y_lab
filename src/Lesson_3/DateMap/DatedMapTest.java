package Lesson_3.DateMap;

import java.time.LocalTime;
import java.util.HashMap;

public class DatedMapTest {
    public static void main(String[] args) {
        DatedMapImp k = new DatedMapImp();
        //HashMap k = new HashMap();
        LocalTime date = LocalTime.now(); // получаем текущую дату
        //System.out.println(date);
        k.put("1","a" );
        k.put("2","a" );
        k.put("3","a" );
        System.out.println(k.get("2"));
        System.out.println(k.get("4"));
        System.out.println(k.cointainsKey("2"));
        System.out.println(k.cointainsKey("4"));
        System.out.println(k.getKeyLastInsertionDate("2"));
        System.out.println(k.getKeyLastInsertionDate("4"));
        System.out.println(k.keySet());

    }
}
