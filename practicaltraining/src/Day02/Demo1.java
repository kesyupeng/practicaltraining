package Day02;


import java.util.Scanner;

public class Demo1 {
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
		
		gid[1]=2;
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
		String am=null;
		do
		{
			am="n";
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
				String as=null;
				do
				{
					as="n";
					System.out.println("-------------------------------");
					System.out.println("              1.登录");
					System.out.println("              2.注册");
					System.out.println("请选择:");
					int a=input.nextInt();
					if(a==1)
					{
						String aq=null;
						do
						{
							aq="n";
							boolean isFlag=false;
							System.out.println("请输入用户名:");
							String name=input.next();
							System.out.println("请输入密     码:");
							String pwd=input.next();
							for(int i=0;i<10;i++)
							{
								if(uname[i]!=null)
								{
									if(uname[i].equals(name)&&password[i].equals(pwd))
									{
										username=name;
										isFlag=true;
										break;
									}
								}
							}
							if(isFlag)
							{
								System.out.println("登录成功，欢迎用户"+username);
							}
							else
							{
								System.out.println("登录失败，请重新输入用户名或密码!");
							    aq="y";
							}
						}while(aq.equals("y"));
					}
					else if(a==2)
					{
						String name=null;
						String aq=null;
						do
						{
							aq="n";
							boolean isFlag=false;
							System.out.println("请输入用户名:");
							name=input.next();
							for(int i=0;i<10;i++)
							{
								if(uname[i]!=null)
								{
									if(uname[i].equals(name))
									{
										isFlag=true;
										break;
									}
								}
							}
							if(isFlag)
							{
								System.out.println("该用户名已被占用，请重新输入!");
								aq="y";
							}
						}while(aq.equals("y"));
						String pwd=null;
						String al=null;
						do
						{
							al="n";
							System.out.println("请输入密码:");
							pwd=input.next();
							if(pwd.length()<6)
							{
								System.out.println("密码长度不能少于六位，请重新输入!");
								al="y";
							}
						}while(al.equals("y"));
						String confPwd=null;
						String ap=null;
						do
						{
							ap="n";
							System.out.println("请输入确认密码:");
							confPwd=input.next();
							if(!confPwd.equals(pwd))
							{
								System.out.println("确认密码和密码我不一致，请重新输入!");
								ap="y";
							}
						}while(ap.equals("y"));
						double regMoney=0;
						String ak=null;
						do
						{
							ak="n";
							System.out.println("请输入注册金额:");
							regMoney=input.nextDouble();
							if(regMoney<100)
							{
								System.out.println("注册金额不能低于100元，请重新输入!");
								ak="y";
							}
						}while(ak.equals("y"));
						for(int i=0;i<10;i++)
						{
							if(uname[i]==null)
							{
								uid[i]=uid[i-1]+1;
								uname[i]=name;
								password[i]=pwd;
								money[i]=regMoney;
								break;
							}
						}
						username=name;
						System.out.println("注册成功，欢迎新用户"+username);
					}
					else
					{
						System.out.println("输入错误，请重新选择:");
						as="y";
					}
				}while(as.equals("y"));
			}
			boolean flag=false;
			for(int i=0;i<10;i++)
			{
				if(type[i]!=null)
				{
					if(type[i].equals(typeName))
					{
						if(gid[i]==n)
						{
							flag=true;
							break;
						}
					}
				}
			}
			if(flag==false)
			{
				System.out.println("输入错误，请重新选择!");
				am="y";
			}
		}while(am.equals("y"));
	}
}
