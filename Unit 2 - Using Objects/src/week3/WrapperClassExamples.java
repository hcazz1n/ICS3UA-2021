package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer x = new Integer(7); //explicitly consturcting an Integer Object
        Double num = 3.4; //auto-boxing (Java creates a Double object before assignment)

        double d1 = num;

        System.out.println(num.doubleValue());
        System.out.println(num);

        System.out.println(x.intValue());
        System.out.println(x);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //static activate through class, (line 16 and 17), non-static activate through object, (line 13)
        }


}
