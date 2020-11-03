package day02;

public class ExampleBean {
	private int age;
	private double price;
	private float value;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ExampleBean [age=" + age + ", price=" + price + ", value=" + value + ", name=" + name + "]";
	}
	
	
}
