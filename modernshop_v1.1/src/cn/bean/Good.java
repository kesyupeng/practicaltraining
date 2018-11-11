package cn.bean;

public class Good {
	private int id;
	private String name;
	private String place;
	private double price;
	private int number;
	private String type;
	public Good() {
		super();
	}
	public Good(int id, String name, String place, double price, int number,
			String type) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.price = price;
		this.number = number;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
