package week6;

public class NestedLoops {
    public static void main(String[] args) {
        //exampleOne();
        //framingSquares(1, 2, 3, 4);
        //wordFrame("CANADA");
        diamonds("CANADA");
    }

    private static void diamonds(String str) {
        for(int i = 0; i < str.length() - 1; i++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));

        for(int i = 1; i < str.length(); i++){
            for(int j = 1; j < str.length() - 1 - i; j++){
                System.out.print(" ");
            }
            System.out.println(str.substring(i, i + 1));
        }
        

        for(int i = 0; i < str.length() - 1; i++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
    }

    private static void wordFrame(String str) {
        System.out.println("*" + str + "*");
        for(int i=0; i < str.length(); i++){
            String start = str.substring(i, i + 1);
            String end = str.substring(str.length() - i - 1, str.length() - i);
            System.out.println(end + "" + start);
        }
        System.out.print("*");
        for(int i=5; i >= 0; i--){
            String words = str.substring(i, i + 1);
            System.out.print(words);
        }
        System.out.print("*");
    }

    private static void framingSquares(int m, int n, int p, int q) {
        for(int i = 0; i < q; i++){
            for(int j = 0; j < 2*p + 2*q + n; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i=0; i < p; i++){
            for(int j=0; j < q; j++){
                System.out.print("#");
            }

            for(int j=0; j < 2*p + n; j++){
                System.out.print("+");
            }

            for(int j=0; j < q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i=0; i < m; i++){
            for(int j=0; j < q; j++){
                System.out.print("#");
            }
            for(int j=0; j < p; j++){
                System.out.print("+");
            }
            for(int j=0; j < n; j++){
                System.out.print(".");
            }
            for(int j=0; j < p; j++){
                System.out.print("+");
            }
            for(int j=0; j < q; j++){
                 System.out.print("#");
            }
            System.out.println();
        }
        for(int i=0; i < p; i++){
            for(int j=0; j < 0; j++){
                System.out.print("#");
            }

            for(int j=0; j < 2*p + n; j++){
                System.out.print("+");
            }

            for(int j=0; j < 0; j++){
                System.out.print("#");
            }
            System.out.println();
        }
        for(int i = 0; i < q; i++){
            for(int j = 0; j < 2*p + 2*q + n; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void exampleOne() {
        for(int r = 1; r <= 5; r++){
            for(int c = 1; c <= 10; c++){
                System.out.print(c * r + " ");
            }
            System.out.println();
        }
    }
}
