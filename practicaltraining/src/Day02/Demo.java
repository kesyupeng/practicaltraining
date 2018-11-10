package Day02;


import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String username=null;//存储登录成功或新注册成功的用户名的
		//定义存储用户和商品信息的数组
		int[] uid=new int[10];
		String[] uname=new String[10];
		String[] password=new String[10];
		double[] money=new double[10];
		
		int[] gid=new int[10];
		String[] gname=new String[10];
		String[] place=new String[10];
		double[] price=new double[10];
		int[] number=new int[10];
		String[] type=new String[10];
		//初始化
		uid[0]=1001;
		uname[0]="admin";
		password[0]="123456";
		money[0]=1000;
		
		gid[0]=1;
		gname[0]="TCL42吋液晶彩电";
		place[0]="CHINA";
		price[0]=4200;
		number[0]=10;
		type[0]="电器";
		
		gid[1]=1;
		gname[1]="海尔节能冰箱";
		place[1]="CHINA";
		price[1]=4500;
		number[1]=10;
		type[1]="电器";
		
		gid[2]=3;
		gname[2]="西门子绿色洗衣机";
		place[2]="CHINA";
		price[2]=5200;
		number[2]=5;
		type[2]="电器";
		
		System.out.println("=========================================");
		System.out.println("                   现代商城");
		System.out.println("=========================================");
		String an=null;
		String typeName=null;
		do
		{
			an="n";
			System.out.println("商品类型:");
			System.out.println("                  1.电器");
			System.out.println("                  2.服饰");
			System.out.println("                  3.水果");
			System.out.println("请选择:");
			int m=input.nextInt();
			if(m==1)
			{
				typeName="电器";
			}
			else if(m==2)
			{
				typeName="服饰";
			}
			else if(m==3)
			{
				typeName="水果";
			}
			else
			{
				System.out.println("输入错误，请重新选择!");
				an="y";
			}
		}while(an.equals("y"));
		for(int i=0;i<10;i++)
		{
			if(gname[i]!=null)
			{
				if(type[i].equals(typeName))
				{
					System.out.println(gid[i]+"\t"+gname[i]+"\t"+place[i]+"\t"+price[i]+"\t"+number[i]);
				}
			}
		}
		System.out.println("请输入要购买的商品编号:");
		int n=input.nextInt();
		if(username==null)
		{
			System.out.println("您还没有登录，请登录或注册先!");
			System.out.println("-------------------------------");
			System.out.println("              1.登录");
			System.out.println("              2.注册");
		}
	}
}
