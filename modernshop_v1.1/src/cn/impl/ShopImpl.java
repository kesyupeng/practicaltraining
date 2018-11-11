package cn.impl;

import java.util.Scanner;

import cn.bean.Good;
import cn.bean.Order;
import cn.bean.User;

public class ShopImpl {
	Scanner input=new Scanner(System.in);
	User[] user=new User[10];
	Good[] good=new Good[10];
	Order[] order=new Order[10];
	String username=null;
	
	//[start] 初始化
	public void init()
	{
		user[0]=new User(1001,"admin","123456",1000);
		for(int i=1;i<10;i++)
		{
			user[i]=new User();
		}
		good[0]=new Good(1,"TCL42吋液晶彩电","china",4200,10,"电器");
		good[1]=new Good(2,"海尔节能冰箱","china",5200,10,"电器");
		good[2]=new Good(3,"西门子绿色洗衣机","china",6200,10,"电器");
		for(int i=3;i<10;i++)
		{
			good[i]=new Good();
		}
		for(int i=0;i<10;i++)
		{
			order[i]=new Order();
		}
	}//[end]
	
	public void show()
	{
		//[start] 现代商城系统
		String ax=null;
		do
		{
			init();
			username=null;
			System.out.println("=========================================");
			System.out.println("                   现代商城");
			System.out.println("=========================================");
			
			//[start] 功能
			String ar=null;
			do
			{
				
				//[start] 菜单
				int m=0;
			    String goodType=null;
				//String typeName=null;
				do
				{
					goodType="n";
					System.out.println("商品类型:");
					System.out.println("                  1.电器");
					System.out.println("                  2.服饰");
					System.out.println("                  3.水果");
					System.out.println("请选择:");
					m=input.nextInt();
					if(m==1)
					if(m!=1&&m!=2&&m!=3)
					{
						System.out.println("输入错误，请重新选择!");
						goodType="y";
					}
				}while(goodType.equals("y"));//[end]
				
				
				//[start] 登录注册
				String av=null;
				do
				{
					String typeName=getTypeName(m);
					showGoodByType(typeName); //商品列表
					
					//[start] 登录注册
					String am=null;
					int n=0;
					do
					{
						am="n";
					
						System.out.println("请输入要购买的商品编号:");
						n=input.nextInt();
						
						
						if(!login())
						{
							System.out.println("您还没有登录，请登录或注册先!");
							
							//[start] longinRegister循环
							String longinRegister=null;
							do
							{
								longinRegister="n";
								System.out.println("-------------------------------");
								System.out.println("              1.登录");
								System.out.println("              2.注册");
								System.out.println("请选择:");
								int a=input.nextInt();
								if(a==1)
								{
									//[start] 登录
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
											if(user[i].getName()!=null)
											{
												if(user[i].getName().equals(name)&&user[i].getPassword().equals(pwd))
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
									}while(aq.equals("y"));//[end]
								}
								else if(a==2)
								{
									//[start] 注册用户名
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
											if(user[i].getName()!=null)
											{
												if(user[i].getPassword().equals(name))
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
									}while(aq.equals("y"));//[end]
									
									//[start] 输入密码
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
									}while(al.equals("y"));//[end]
									
									//[start] 确认密码
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
									}while(ap.equals("y"));//[end]
									
									//[start] 注册金额
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
									}while(ak.equals("y"));//[end]
									
									for(int i=0;i<10;i++)
									{
										if(user[i].getName()==null)
										{
											user[i].setId(user[i+1].getId()+1);
											user[i].setName(name);
											user[i].setPassword(pwd);
											user[i].setMoney(regMoney);
											break;
										}
									}
									username=name;
									System.out.println("注册成功，欢迎新用户"+username);
								}
								else
								{
									System.out.println("输入错误，请重新选择:");
									longinRegister="y";
								}
							}while(longinRegister.equals("y"));//[end]
						}
						boolean flag=false;
						for(int i=0;i<10;i++)
						{
							if(good[i].getType()!=null)
							{
								if(good[i].getType().equals(typeName))
								{
									if(good[i].getId()==n)
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
					}while(am.equals("y"));//[end]
					
					//[start] 购买数量，清单结算
					String ab=null;
					do
					{
						ab="n";
						boolean igFlag=false;
						System.out.println("请输入要购买的数量:");
						int b=input.nextInt();
						for(int i=0;i<10;i++)
						{
							if(good[i].getName()!=null)
							{
								if(good[i].getId()==n)
								{
									if(good[i].getNumber()<b)
									{
										igFlag=true;
									}
									else
									{
										good[i].setNumber(good[i].getNumber()-b);
										boolean lg=false;
										for(int j=0;j<10;j++)
										{
											if(order[j].getGid()!=0)
											{
												if(order[j].getGid()==n)
												{
													lg=true;
													order[j].setNum(order[j].getNum()+b);
													break;
												}
											}
		                                 }
										if(lg==false)
										{
											for(int j=0;j<10;j++)
											{
												if(order[j].getGid()==0)
												{
													order[j].setGid(n);
													order[j].setNum(order[j].getNum()+b);
													break;
												}
											}
										}
									}
									break;
								}
							}
						}
						if(igFlag)
						{
							System.out.println("库存不足，请重新选择！");
							ab="y";
						}
					}while(ab.equals("y"));//[end]
					
					System.out.println("请问要继续购买"+typeName+"吗?");
					av=input.next();
				}while(av.equals("y"));//[end]
				
				System.out.println("请问要继续购物吗?");
				ar=input.next();
			}while(ar.equals("y"));//[end]
			
			//[start] 购物清单
			double total=0;
			System.out.println("-----------您的购物清单------------");
			for(int i=0;i<10;i++)
			{
				if(order[i].getGid()!=0)
				{
					for(int j=0;j<10;j++)
					{
						if(good[j].getId()!=0&&good[j].getId()==order[i].getGid())
						{
							System.out.println(good[j].getId()+"\t"+good[j].getName()+"\t"+good[j].getPrice()+"\t"+order[i].getNum()+"\t"+good[j].getPrice()*order[i].getNum());
						    total=total+good[j].getPrice()*order[i].getNum();
						}
					}
				}
			}//[end]
			
			boolean lv=false;
			System.out.println("本次共消费"+total+",您的余额不足，请充值!");
			
			//[start] 充值
			String ai=null;
			do
			{
				ai="n";
				System.out.println("请输入充值金额:");
				for(int i=0;i<10;i++)
				{
					if(user[i].getName()!=null)
					{
						if(user[i].getName().equals(username))
						{
							user[i].setMoney(user[i].getMoney()+input.nextDouble());
							if(user[i].getMoney()<total)
							{
								lv=true;
							}
							else
							{
								
								user[i].setMoney(user[i].getMoney()-total);
								lv=false;
								System.out.println("感谢您的本次购物！");
							}
							break;
						}
					}
				}
				if(lv)
				{
					System.out.println("充值金额不够，请再次充值");
					ai="y";
				}
			}while(ai.equals("y"));//[end]
			
			System.out.println("请问要退出吗?");
			ax=input.next();
		}while(ax.equals("y"));//[end]
	}
	
	
	//[start] 显示商品列表
	public void showGoodByType(String typeName) 
	{
		for(int i=0;i<good.length;i++)
		{
			if(good[i].getId()!=0)
			{
				if(good[i].getType().equals(typeName))
				{
					System.out.println(good[i].getId()+"\t"+good[i].getName()+"\t"+good[i].getPlace()+"\t"+good[i].getPrice()+"\t"+good[i].getNumber());
				}
			}
		}
	}//[end]
	
	//[start] 获取商品类型
	public String getTypeName(int m)
	{
		String typeName=null;
		if(m==1)
		{
			typeName="电器";
		}
		else if(m==2)
		{
			typeName="服饰";
		}
		else
		{
			typeName="水果";
		}
		return typeName;
	}//[end]
	
	//[start] 判断是否登录
	public boolean login()
	{
		boolean flag=false;
		if(username==null) {
			flag=false;
		}
		else 
		{
			flag=true;
		}
		return flag;
		
		
	}//[end]
	
	//[start] 注册
	public boolean register()
	{
		return false;
	}//[end]
	
	public void destroy()
	{
		this.username=null;
	}
}
