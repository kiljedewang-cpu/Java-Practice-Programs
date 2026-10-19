package Series;
public class prime{
public void printprime(int n){
System.out.println("Prime numbers:");
int count=0;
int num=2;
while(count<n){
boolean prime=true;
for(int i=2;i<num/2;i++)
{
if(num%i==0){
prime = false;
break;
}
}
if(prime){
System.out.print(num+"");
count++;
}
num++;
}
System.out.println();
}
}
