package Lesson_3.DateMap;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;


public class DatedMapImp extends HashMap implements DatedMap {
    private  HashMap<String, String> Map_DATA = new HashMap();
    //private  HashMap<String, LocalTime> Map_Time = new HashMap<>();
    private  HashMap<String, Date> Map_Date = new HashMap<>();
    @Override
    public void put(String key, String value) {
        // LocalTime date = LocalTime.now(); // получаем текущее время
        Date date = new Date() ; // получаем текущую дату
        Map_DATA.put(key, value);  // карта с данными
        Map_Date.put(key, date);  // соответсвтующая карта со временем создания соответствующих данных
    }

    @Override // получить значение
    public String get(String key) {
        String S = Map_DATA.get(key); // получаем значение с карты с данными
        if (S==null) return null;
            else return S;
    }

    @Override
    public boolean cointainsKey(String key)
    {
        if (Map_DATA.containsKey(key)) return true;
            else return false;
    }

    @Override
    public void remove(String key) {
        Map_DATA.remove(key);
        Map_Date.remove(key);
    }

    @Override
    public Set<String> keySet(){
        return Map_DATA.keySet();
    }
   @Override
    public Date getKeyLastInsertionDate(String key){
        if (Map_DATA.containsKey(key) ) return Map_Date.get(key);
            else return null;
   }

    }

