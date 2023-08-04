package Lesson_3.Transliterator;

public class TransliteratorTest {
    public static void main(String[] args) {
        Transliterator transliterator =new TransliteratorImp();
        String res;
        res= transliterator.transliterate("HELLO! ПРИВЕТ! Go, boy!");
        System.out.println(res);
    }
}
