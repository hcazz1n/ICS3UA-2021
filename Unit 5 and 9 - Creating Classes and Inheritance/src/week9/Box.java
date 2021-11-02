package week9;

public class Box extends Rectangle{
    /* 
    Remember if you do not write a constructor then Java 
    supplies a no-argument constructor that ONLY calls your 
    parent's no-argument constructor.
    
    public Box(){
        super();
    }
    */

    private double height;

    public Box(double l, double w, double h){
        //length = l; //you get everything your parent has BUT the private stuff is not visible
        //width = w;

        super(l, w); //first thing in a constructor is to call one of your parents' constructor. 
        //If you do not then Java will attempt to call your parents' no-argument constructor (implicitly).
        height = h;
    }

    public Box(double s){
        super(s);
        height = s;
    }

    public double getVolume(){
        return super.getArea() * height;
    }

    /*Method overriding - Over write the method that was inherited from our parent */
    public double getArea(){
        return 2 * super.getArea() + 2 * height * getLength() + 2 * height * getWidth();
    }

    public boolean isCube(){
        return isSquare() && height == getLength();
    }
}
