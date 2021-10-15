package week6;

public class ForLoops {
    public static void main(String[] args) {
        forLoopExample3();
    }

    private static void forLoopExample3() {
        int i = 1;
        for(;i < 10;){
            System.out.println("Hi");
            i++;
        }
    }

    private static void forLoopExample() {
        int sum = 0;
        
        for(int i = 1; i <=100; i++){
            sum += i;
        }
        System.out.println(sum);
    }

    private static void forLoopExample2() {
        int sum = 0;
        
        for(int i = 0; i <=100; i+=2){
            sum += i;
        }
        System.out.println(sum);
    }

    private static void whileLoopExample() {
        int i = 1; //i happen first and only once
        int sum = 0;

        while(i <= 100){ //Check the condition over and over
            sum+=1;
            i++; //increment after each time the body executed
        }

        System.out.println(sum);
    }
}
