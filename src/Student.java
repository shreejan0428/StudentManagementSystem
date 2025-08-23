public class Student {
    private String name;
    private String ID;
    private int age;
    private double grade;

    
    public Student(){
        this.name = "No Name"; 
        this.ID = "Does not exist";
        this.age = 0;
        this.grade = 0.0;
    }

    public Student(String name, String ID, int age, double grade){
        this.name = name; 
        this.ID = ID;
        this.age = age;
        this.grade = grade;
    }

    // getters and setters to promote mutability and encapsulation
    public void setName(String name){
        this.name = name; 
    }

    public String getName(){
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void printInfo() {
        System.out.println("Found Student:\n" + "ID: " + ID + "\nName: " + name + "\nAge: " + age + "\nGrade: " + grade);
    }

    @Override 
    public String toString() {
        return "Name: " + name + " ID: " + ID + " Age: " + age + " Grade: " + grade;
    }
}