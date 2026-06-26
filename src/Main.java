import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Studentsql m = new Studentsql();
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
                    m.displayStudents();
                    break;
                case 3:
                    m.searchStudent(sc);
                    break;
                case 4:
                    m.updateStudent(sc);
                    break;
                case 5:
                    m.deleteStudent(sc);
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
}
    
