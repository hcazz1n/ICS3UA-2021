package week1;

public class example6 {
    public static void main(String[] args) {
        int x = 1;
        int y = 3;
        double z = 1;

        x = x+1;
        y = y-1;
        x = x+3;

        y = y/2;
        y/=2;

        z = z*2;
        z*=2;
        
        x+=1; //same function as line 9
        x++;  //same function as line 9
        y-=1; //same function as line 10
        y--;  //same function as line 10
        x+=3; //same function as line 11
        
        //modulous operator %, used for ints

        System.out.println(13%3); //13/3, what is the remainder? 1.

        int a = 5;
        a++;
        ++a;
        a--;
        --a;

        int b = 3;
        int e = 3;

        int c = 2*b++; //c=6, b=4

        int d = 2*++e; //d=8, e=4
    }
}
