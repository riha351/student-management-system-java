import java.util.Scanner;
import java.sql.*;
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
                    m.displayStudents();
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

        try{
            Connection con=DBC.getConnection();
            String sql="INSERT INTO STUDENTS VALUES(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);
            ps.setString(5, email);
            int rows= ps.executeUpdate();
            if (rows>0) 
            {
                System.out.println("Student added successfully!");
            }  
            else 
            {
                System.out.println("Failed to add student.");
            } 
        }
         catch (SQLException e)
        {
            System.out.println(e);
            
        }
    }
    public void displayStudents()
    {
        try{
            Connection con=DBC.getConnection();
            String sql="SELECT * FROM STUDENTS";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) 
            {
                System.out.println("Student details:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Email: " + rs.getString("email"));

            }  
        }
         catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
