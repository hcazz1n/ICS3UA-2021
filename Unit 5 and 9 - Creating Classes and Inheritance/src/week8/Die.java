package week8;

public class Die {
    //attributes - defines the state of the object
    
    //The attributes SHOULD be private
    //private -> visible (accessible) in this class
    private int numSides;
    private int topSide;

    //constructor
    //has the same name as the class
    //you should create at least 1
    //they are used to obtain (construct an instance of the class) 
    //In this case it will give a die
    public Die(){
        numSides = 6;
        topSide = (int)(Math.random() * numSides) + 1;
        //constructor initializes the attributes

    }

    public Die(int numSides){
        //The word "this" refers to the object that we are working with.
        //The object that called the method
        this.numSides = numSides;
        roll();
    }

    public void roll(){
        topSide = (int)(Math.random() * numSides) + 1;
    }

    public int getTopSide(){
        return topSide;
    }
}
