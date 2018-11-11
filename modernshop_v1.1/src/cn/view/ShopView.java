package cn.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.impl.ShopImpl;

public class ShopView {
	public static void main(String[] args) {
		ShopImpl sp=new ShopImpl();
		sp.show();
		
//		Date time=new Date();
//		SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
//		System.out.println(sf.format(time));
	}
}
