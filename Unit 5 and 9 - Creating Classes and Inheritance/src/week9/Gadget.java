package week9;

public class Gadget {
    private static int status = 0; //static variable, non-static AND static methods can access it - will change globally for ALL objects
    //however normally, do not declare static unless you need to share a value among multiple Gadget objects

    private int num = 0; //non-static variable, unique to every instance of the class/object.
    //static methods CANNOT access non-static methods or non-static attributes


}
