import java.util.Scanner;

class vehicle1
{
 protected String company;
 protected double price;
 
 public vehicle1(String company,double price)
 {
    this.company = company;
    this.price = price;
 }
 
 public void display()
 {
    System.out.println("COMPANY" +company);
    System.out.println("PRICE" +price);
}
}

class LMV extends vehicle1
{
  private double mileage;
  public LMV(String company,double price,double mileage)
 {
   super(company,price);
    this.mileage = mileage;
}
 public void display()
{
  super.display();
  System.out.println("MILEAGE" +mileage);
}
}

class HMV extends vehicle1
{
  private double capacity;
 public HMV(String company,double price,double capacity)
 {
    super(company,price);
 this.capacity = capacity;
 }
  public void display()
 {
   super.display();
  System.out.println("CAPACITY" +capacity);
}
}

 class VehicleMain
{
  public static void main(String[] args)
 { int i;
   Scanner sc =new Scanner(System.in);
  System.out.println("Enter N");
  int n = sc.nextInt();
 
 
 vehicle1[] vehicles = new vehicle1[n];
 for(i=0;i<n;i++)
 {  
   System.out.println("Vehicles details");
  System.out.println("Company Name");
  String company = sc.next();
 System.out.println("Price");
  double price = sc.nextDouble();
 System.out.println("Enter Type(1-LMV & 2-HMV)");
 int type = sc.nextInt();
 if(type == 1)
{ System.out.println("Enter Mileage");
  double mileage = sc.nextDouble();
  vehicles[i] = new LMV(company,price,mileage);
}
 else if(type == 2)
{   System.out.println("Enter Capacity");
     double capacity = sc.nextDouble();
 vehicles[i] = new HMV(company,price,capacity);}
 else
   { System.out.println("Invalid");
      vehicles[i] = new vehicle1(company,price);
}}
 for(i = 0;i<n;i++)
{ 
  System.out.println("\n Vehicles Details");
  vehicles[i].display();
}
}
}
