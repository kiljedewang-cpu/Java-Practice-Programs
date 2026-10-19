class Mynumber
{
	private int num;
	
	Mynumber()
	{
		this.num=0;
	}
	
	Mynumber(int num)
	{
		this.num=num;
	
	}
	
	boolean isnegative()
	{
		return num<0;
	}
	
	boolean ispositive()
	{
		return num>0;
	}
	
	boolean iszero()
	{
		return num==0;
	}
	
	boolean isOdd()
	{
		return num%2!=0;
	}
	boolean isEven()
	{
		return num%2==0;
	}
	
	public static void main(String[] args)
	{
		if(args.length==0)
		{
			System.out.println("please provide a number");
			return;
		}
	int value=Integer.parseInt(args[0]);
	Mynumber obj=new Mynumber(value);
	System.out.println("Is positive: "+ obj.ispositive());
	System.out.println("Is negative: "+ obj.isnegative());	
	System.out.println("Is Zero: "+ obj.iszero());
	System.out.println("Is Odd: "+ obj.isOdd());
	System.out.println("Is Even:    "+ obj.isEven());	
	
	}
	}
