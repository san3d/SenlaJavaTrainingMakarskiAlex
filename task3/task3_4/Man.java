package task3_4;

public class Man {

	protected String name;
	protected String surname;
	protected int age;

	public Man() {
		System.out.println("Man created!");
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String s) {
		surname = s;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}
}