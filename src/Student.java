public class Student
{
    int id;
    int age;
    String name;
    String course;
    String email;

    public Student(int id, String name, int age, String course, String email)
    {
        this.id = id;
        this.age = age;
        this.name = name;
        this.course = course;
        this.email = email;
    }
    public int getId()
    {
        return id;
    }
    public int getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
    public String getCourse()
    {
        return course;
    }
    public String getEmail()
    {
        return email;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setName(String name)
    {
        this.name = name;       
    }
    public void setCourse(String course)
    {
        this.course = course;
    }
    public void setEmail(String email)
    {
        this.email = email; 
    }
}
