package week10;

public class ArrayExamples {
    public static void main(String[] args) {
        primitiveArray();
        arrayObjectExample();
    }

    private static void arrayObjectExample() {
        Animal[] animals = new Animal[3];
        animals[0] = new Animal();
    }

    private static void primitiveArray() {
        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 6;
        arr[2] = 69;
        arr[3] = 123;
        arr[4] = -123456789;
        System.out.println(arr[2]);
    }
}
