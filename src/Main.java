import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Main m=new Main();
        while(true)
        {
            System.out.println("MENU");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    m.addStudent(sc);
                    break;
                case 2:
                    System.out.println("Display Students");
                    break;
                case 3:
                    System.out.println("Search Student");
                    break;
                case 4:
                    System.out.println("Update Student");
                    break;
                case 5:
                    System.out.println("Delete Student");
                    break;
                case 6:
                    System.out.println("Exiting");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
       
    }
    public void addStudent(Scanner sc)
    {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Student Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Student Email: ");
        String email = sc.nextLine();

        Student s = new Student(id, name, age, course, email);

        System.out.println("Student added successfully!");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
        System.out.println("Course: " + s.getCourse());
        System.out.println("Email: " + s.getEmail());

    }
}
