package task3_3;

public class Accountants extends Employ {

	protected String position;

	public Accountants(String name, int salary, String position) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		System.out.println("Accountant "+name+" created!");
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}