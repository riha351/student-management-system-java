import java.util.Scanner;
import java.sql.*;
public class Studentsql {
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
    public void searchStudent(Scanner sc)
    {
        try{
            Connection con=DBC.getConnection();
            System.out.println("Enter Student Register Number:");
            int id=sc.nextInt();
            String sql="SELECT * FROM STUDENTS WHERE ID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                System.out.println("Student found");
                System.out.println("Register Number: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Email: " + rs.getString("email"));

            }
            else
            {
                System.out.println("Student not found.");
            }

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
    public void updateStudent(Scanner sc)
    {
        System.out.println("Enter Student Register Number to update:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Student Name:");
        String name=sc.nextLine();
        System.out.println("Enter new Student Age:");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Student Course:");
        String course=sc.nextLine();
        System.out.println("Enter new Student Email:");
        String email=sc.nextLine();

        try{
            Connection con=DBC.getConnection();
            String sql="UPDATE STUDENTS SET NAME=?, AGE=?, COURSE=?, EMAIL=? WHERE ID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setString(4, email);
            ps.setInt(5, id);
            int rows= ps.executeUpdate();
            if (rows>0) 
            {
                System.out.println("Student updated successfully!");
            }  
            else 
            {
                System.out.println("Failed to update student.");
            } 
        }
         catch (SQLException e)
        {
            System.out.println(e);
            
        }
    }
    public void deleteStudent(Scanner sc)
    {
        System.out.println("Enter Student id to be deleted");
        int id=sc.nextInt();
        try{
            Connection con=DBC.getConnection();
            String sql="DELETE FROM STUDENTS WHERE ID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows=ps.executeUpdate();
            if(rows>0)
            {
                System.out.println("Student details deleted sucessfully");
            }
            else
            {
                System.out.println("Student details not found");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
