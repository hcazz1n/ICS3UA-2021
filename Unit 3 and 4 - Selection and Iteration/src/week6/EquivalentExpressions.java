package week6;

public class EquivalentExpressions {
    public static void main(String[] args) {
        //boolean expressions evaluate to TRUE / FALSE
        int x = 7;

        System.out.println(x > 3);

        //equivalent expressions are a different way to write the expression but it evaluates to the same values

        // (x < 3) || (x > 7) Diagram in OneNote - red part
        // !(x >= 3) && (x <= 7) Diagram in OneNote - blue part

        //DeMorgan's Laws:
        // A || B                         A and B refer to SIMPLE expressions like (x > 8)
        // !(A || B) = !A && !B
        // !(A && B) = !A || !B
    }
}
