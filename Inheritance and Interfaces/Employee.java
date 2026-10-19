import java.util.Scanner;
class ass3{
private int id;
private String name;
private String dep;
private double sal;

public ass3()
{
this.id=0;
this.name="ark";
this.dep="job";
this.sal=0.0;
}
public ass3(int i,String n,String d,double s)
{
this.id=i;
this.name=n;
this.dep=d;
this.sal=s;
}
public void accept()
{
Scanner sc=new Scanner(System.in);
System.out.println("enter id");
this.id=sc.nextInt();
System.out.println("enter name");
this.name=sc.next();
System.out.println("enter dep");
this.dep=sc.next();
System.out.println("enter sal");
this.sal=sc.nextDouble();
}
public void display()
{
System.out.println("id"+id);
System.out.println("name"+name);
System.out.println("dep"+dep);
System.out.println("sal"+sal);
}

public double getsal()
{
return this.sal;
}}
class manager extends ass3
{
private double bonus;
public manager(){
super();
this.bonus=0.0;
}
public manager(int id,String name,String dep,double sal,double bonus)
{
super(id,name,dep,sal);
this.bonus=bonus;
}
public void accept(){
super.accept();
Scanner sc=new Scanner(System.in);
System.out.println("enter bonus");
this.bonus=sc.nextDouble();
}
public void display(){
super.display();
System.out.println("bonus"+bonus);
System.out.println("total sal"+gettotalsal());
}
public double gettotalsal()
{
return super.getsal()+this.bonus;
}
}

public class Employee{
public static void main(String[] args)
{
int i;
Scanner sc=new Scanner(System.in);
System.out.println("enter no of managers");
int n=sc.nextInt();
manager[] managers=new manager[n];
for(i=0;i<n;i++)
{
System.out.println("\n enter details"+(i+1)+":");
managers[i]=new manager();
managers[i].accept();
}
int maxindex=0;
for(i=1;i<n;i++){
if(managers[i].gettotalsal()>managers[maxindex].gettotalsal())
{
maxindex=i;
}
System.out.println("manager with max sal:");
managers[maxindex].display();

}
}

}
