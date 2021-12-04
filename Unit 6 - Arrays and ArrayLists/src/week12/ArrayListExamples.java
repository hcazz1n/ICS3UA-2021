package week12;

import java.util.ArrayList;

public class ArrayListExamples {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Stuff");
        words.add("More Stuff");
        words.add("More Stuff2");
        words.add("More Stuff3");
        words.add("More Stuff4");
        
        words.remove(0);
        words.add(0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }
}
