

public class Assignvalue {
    int num;
    public Assignvalue(){
        num=0;
    }
    public void assignValue(int x)
    {
        num=x;
    }
    public void display(){
     System.out.println("number= "+num);   
    }
    public static void main(String[] args)
    {
        Assignvalue obj=new Assignvalue();
        obj.assignValue(10);
        obj.display();
    }
}
