package Day01;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Scanner;


public class Demo {
	Scanner input=new Scanner(System.in);
	@Test
	public void test01()
	{
		int[] num=new int[5];
		System.out.println("please input five integer number");
		for(int i=0;i<5;i++)
		{
			System.out.println("please input the"+(i+1)+" number");
			num[i]=input.nextInt();
		}
		System.out.println("before order by");
		for(int i=0;i<5;i++)
		{
			System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("order by");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4-i;j++)
			{
				if(num[j]>num[j+1])
				{
					int temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
			}
		}
		System.out.println("after order by");
		for(int i=0;i<5;i++)
		{
			System.out.print(num[i]+" ");
		}
	}
	
	@Test
	public void test02()
	{
		String an=null;
		do
		{
			System.out.println("please input the line of 菱形");
			int num=input.nextInt();
			if(num%2==0)
			{
				System.out.println("菱形只能是奇数行!");
			}
			else
			{
				int m=num/2+1;
				for(int i=1;i<=m;i++)
				{
					for(int j=1;j<=m-i;j++)
					{
						System.out.print(" ");
					}
					for(int k=1;k<=2*i-1;k++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
				int n=num-m;
				for(int i=1;i<=n;i++)
				{
					for(int j=1;j<=i;j++)
					{
						System.out.print(" ");
					}
					for(int k=1;k<=num-2*i;k++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
			}
			System.out.println("请问要继续吗?");
			an=input.next();
		}while(an.equals("y"));
	}
}

