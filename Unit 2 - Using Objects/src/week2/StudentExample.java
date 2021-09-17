package week2;

public class StudentExample {
    public static void main(String[] args) {
        //richie is a variable to an instance of the class Student
        //richie is an Object (instances of a class)
        Student richie = new Student("Richie", "45646", 10);
        Student yola = new Student("Yola", "123456", 10);

        //richie and yola are references to 2 different students

        Student rastin = richie;

        //holds the reference of richie (what defines richie as a student)

        rastin.increaseGrade();

        //because rastin and richie refer to the same student object, it increases the grade for both
        //(still only 1 object)

        richie = null;
        //Student tristan; tristan is currently the null reference

        //richie.increaseGrade(); //throws java.lang.NullPointerException because richie is null

        yola.addTest(87);
        yola.displayAverage();
        yola.addTest(91);
        yola.displayAverage();
        yola.addTest(97);
        yola.displayAverage();
        yola.addTest(67);
        yola.displayAverage();

        Student harrison = new Student("Harrison", "547235"); 
        double yolaAverage = yola.getAverage();
        System.out.println(yola.getName() + " has an average of " + yolaAverage);

        
    } 
}
