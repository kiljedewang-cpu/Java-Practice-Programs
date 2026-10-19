import java.util.Scanner;
import Series.*;

class series{
public static void main(String args[])
{
Scanner sc=new Scanner (System.in);
System.out.print("Enter Number of terms");
int n=sc.nextInt();
prime p=new prime();
fibonacci f=new fibonacci();
square s=new square();
p.printprime(n);
f.printfibonacci(n);
s.printsquare(n);
sc.close();
}
}
