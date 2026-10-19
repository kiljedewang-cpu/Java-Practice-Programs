public class Student
{
int rollno;
float percentage;
String Name;
static int count=0;

public Student()
{
rollno=5;
Name= "demon";
percentage=0;
}


Student(int r,String n,float p)
{
rollno=r;
Name=n;
percentage=p;
count++;
}

static void ShowCount()
{
System.out.println("object count=" +count);
}

void display()
{
System.out.println("Student Details");
System.out.println("Rollno=" +rollno);
System.out.println("Name=" +Name);
System.out.println("percentage" +percentage);
}

public static void main(String[] args)
{
Student s2 = new Student(90,"ken",60);
Student.ShowCount();
s2.display();
System.out.println();

Student s3 = new Student(300,"arther",40);
Student.ShowCount();
s3.display();
System.out.println();

Student s4 = new Student(56,"evan",50);
Student.ShowCount();
s4.display();

}
}
