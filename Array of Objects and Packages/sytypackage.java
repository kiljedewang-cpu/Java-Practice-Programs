import java.util.Scanner;

import SY.SYMarks;
import TY.TYMarks;

class sytypackage{
int rollno;
String Name;
SYMarks symarks;
TYMarks tymarks;

public sytypackage(int r,String n,SYMarks symark,TYMarks tymark)
{
 this.rollno=r;
  this.Name=n;
  this.symarks=symark;
  this.tymarks=tymark;
}

void display()
{
 int computer = symarks.CompTotal+tymarks.Theory+tymarks.Practical;
 int maths = symarks.MathsTotal+tymarks.Theory+tymarks.Practical;
 int electronics = symarks.ElectTotal+tymarks.Theory+tymarks.Practical;
double perc = (computer+maths+electronics) / 3.0;
 String grade;
 String result;

if(perc >= 70)
grade = "A";
else if(perc >= 60)
grade = "B";
else if(perc >= 50)
grade = "C";
else
grade = "F";
if(perc >= 40)
result = "PASS";
else
result = "FAIL";

System.out.println("-------Student Result--------");
System.out.println("RollNo:" +rollno);
System.out.println("Name:" +Name);
System.out.println("Computer:" +computer);
System.out.println("Maths:" +maths);
System.out.println("Electronics:" +electronics);
System.out.println("percentage:" +perc);
System.out.println("Result:" +result);
}


public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter RollNo:");
int roll = sc.nextInt();
System.out.println("Enter Name:");
String name = sc.next();
System.out.println("Enter SYMarks:");
System.out.println("Computer Total");
int computer = sc.nextInt();
System.out.println("Maths Total");
int maths = sc.nextInt();
System.out.println("Electronics Total");
int electronics = sc.nextInt();
System.out.println("Enter TYMarks:");
System.out.println("theory ");
int theory = sc.nextInt();
System.out.println("Practical:");
int practicals = sc.nextInt();
SYMarks sy = new SYMarks(computer,maths,electronics);
TYMarks ty = new TYMarks(theory,practicals);

sytypackage s = new sytypackage(roll,name,sy,ty);
s.display();

sc.close();
}
}
