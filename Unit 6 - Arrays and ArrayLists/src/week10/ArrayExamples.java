package week10;

public class ArrayExamples {
    public static void main(String[] args) {
        primitiveArray();
        arrayObjectExample();
        iterateArrayExample();
        int[] arr = {9, 8, 7, 6, 5};
        mystery(arr);
    }

    private static void mystery(int[] arr) {
        int index = (int)(Math.random() * arr.length);
        arr[index] = -arr[index];
    }

    private static void iterateArrayExample() {
        int[] arr = {1, 2, 3, 4, 5};

        int numOdd = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1){
                numOdd++;
            }
        }
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
