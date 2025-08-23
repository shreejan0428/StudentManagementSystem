import java.util.*;

public class Main{
    public static void main(String[] args) {

        // Create an ArrayList to store Student objects
        ArrayList<Student> school = new ArrayList<Student>();
       
       // Create 4 student objects
        Student student1 = new Student("Shreejan", "sxr220177", 20, 2.67); 
        Student student2 = new Student("Joseph", "jwr990191", 19, 3.5);
        Student student3 = new Student("Cameron", "cwr220345", 20, 2.12);

        // Add the students to the arraylist
        school.add(student1);
        school.add(student2);
        school.add(student3);

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Management System!");
       
        // Menu
        do {
            try{
                System.out.println("Choose an option from the menu below:");
                System.out.println("1. Add Student");
                System.out.println("2. View all Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student Grade");
                System.out.println("5. Delete Student by ID");
                System.out.println("6. Exit the program");
                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 6)
                    throw new InvalidMenuChoiceException("Menu options are only from 1-6");
            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input. Input must be an integer.");
                scanner.nextLine();
                choice = 0;
            }
            catch(InvalidMenuChoiceException e) {
                System.out.println("Invalid Menu choice. " + e.getMessage());
            }

            if (choice == 1) {
                addStudents(school, scanner);
            }
            else if (choice == 2) {
                System.out.println(school);
            }
            else if (choice == 3) {
                searchStudents(school, scanner);
            }
            else if (choice == 4) {
                updateGrade(school, scanner);
            }
            else if (choice == 5) {
                deleteStudent(school, scanner);
            }
            else if (choice == 6) {
                System.out.println("Exiting the program!");
            }
        }
        while (choice != 6);
        scanner.close();
    }
    
    public static void addStudents(ArrayList<Student> list, Scanner scanner) {   
        System.out.println("Do you want to add the student with unknown details or do you want to provide the details? Type 'unknown' or 'provide' respectively.");
       
            String input = scanner.nextLine(); 
            if (input.equals("provide")) {
                String name, ID;
                int age;
                double grade;
                try {
                System.out.println("What is the student's name?");
                name = scanner.nextLine();
                System.out.println("What is the student's ID?");
                ID = scanner.nextLine();
                System.out.println("What is the student's age?");
                age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What is the student's grade?");
                grade = scanner.nextDouble();
                scanner.nextLine();
                Student student = new Student(name, ID, age, grade);
                list.add(student);
                System.out.println("You have successfully added " + name);
                }
                catch(InputMismatchException e) {
                    System.out.println("Invalid entry.");
                }
            }
            else if (input.equals("unknown")) {
                Student student = new Student();
                list.add(student);
                System.out.println("You have successfully added a student");
            }
            else {
                System.out.println("Invalid option. 'unknown' or 'provide' are the only options accepted.");
            }
        }

    public static void searchStudents(ArrayList<Student> list, Scanner scanner) {
        System.out.println("What is the student's ID?");
        String ID = scanner.nextLine();
        boolean validID = false;
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getID().equals(ID)) {
                ID = list.get(i).getID();
                list.get(i).printInfo();
                validID = true;
            }

        }
        if (!validID) {
            System.out.println("You have entered an invalid ID");
        }

        
    }

    public static void updateGrade(ArrayList<Student> list, Scanner scanner) {
        System.out.println("Enter the student ID of the student whose grade you want to update.");
        String ID = scanner.nextLine();
        boolean validID = false;
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getID().equals(ID)) {
                ID = list.get(i).getID();
                System.out.println("Enter " + list.get(i).getName() + "'s new grade.");
                try {
                double newGrade = scanner.nextDouble();
                scanner.nextLine();
                list.get(i).setGrade(newGrade);
                }
                catch(InputMismatchException e) {
                    System.out.println("Invalid entry. You must enter a double value.");
                }
                validID = true;
            }
        }

        if (!validID) {
            System.out.println("You have entered an invalid ID");
        }

    }

    public static void deleteStudent(ArrayList<Student> list, Scanner scanner) {
        System.out.println("Enter the student ID of the student that you want to delete from the system.");
        String ID = scanner.nextLine();
        boolean validID = false;
        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getID().equals(ID)) {
                list.remove(i);
                System.out.println("You have successfully removed the student from the system.");
                validID = true;
            }
        }
        if (!validID) {
            System.out.println("You have entered an invalid ID");
        }

    }
}

class InvalidMenuChoiceException extends Exception{
    public InvalidMenuChoiceException(String message){
        super(message);
    }
}
