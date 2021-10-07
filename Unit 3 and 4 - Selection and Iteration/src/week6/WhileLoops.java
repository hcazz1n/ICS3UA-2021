package week6;

public class WhileLoops {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        int numVowels = countVowels("This is a sentence with vowels");
        System.out.println(numVowels);
    }


    private static int countVowels(String str) {
        int numVowels = 0;
        String vowels = "AEIOUaeiou";
        int index = 0;

        while(index < str.length()) {
            String nextChar = str.substring(index, index + 1);
            if(vowels.indexOf(nextChar) >= 0) {
                numVowels++;
            }
            index++;
        }
        return numVowels;
    }


    public static void exampleTwo() {
        int num = 1;
        int total = 0;

        while(num <= 100) {
            total += num;
            num++;
            
        }
        System.out.println(total);
    }


    public static void exampleOne() {

        int num = 1;

        while(num < 10) {
            System.out.println(num);
            num++;
        }

    }

}
