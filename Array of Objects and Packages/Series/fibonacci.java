package Series;
public class fibonacci{
public void printfibonacci(int n){
System.out.println("Fibonacci series:");
int a=0,b=1;
for(int i=1;i<=n;i++){
System.out.print(a+" ");
int c=a+b;
a=b;
b=c;
}
System.out.println();
}
}
