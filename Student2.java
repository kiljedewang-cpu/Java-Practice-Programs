import java.util.Scanner;

public class Student2
{
int rollno;
float percentage;
String Name;
static int count=0;

Student2(int r,String n,float p)
{
rollno=r;
Name=n;
percentage=p;
count++;
}


static void ShowCount()
{
System.out.println("object Count=" +count);
}

void display()
{
System.out.println("Student Details:-");
System.out.println("Rollno=" +rollno);
System.out.println("Name=" +Name);
System.out.println("percentage=" +percentage);
}

static void sort(Student2 S[])
{

for(int i=0;i<S.length-1;i++)
{
for(int j=i+1;j<S.length;j++)
{
if(S[i].percentage<S[j].percentage)
{
Student2 temp = S[i];
S[i]=S[j];
S[j]=temp;
}}}}

public static void main(String[] args)
{
int i;
Scanner sc = new Scanner(System.in);
System.out.println("Enter no.of students");
int n = sc.nextInt();
Student2 S[] = new Student2 [n];
for(i=0;i<n;i++)
{
System.out.println("Enter Details of student");
System.out.println("Enter rollno:");
int r = sc.nextInt();
System.out.println("Enter name:");
String name = sc.next();
System.out.println("Enter percentage");
float p = sc.nextInt();
S[i] = new Student2(r,name,p);
Student2.ShowCount();
}
Student2.sort(S);
for(i=0;i<n;i++)
{
S[i].display();
}
sc.close();
}
}
