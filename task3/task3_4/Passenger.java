package task3_4;

public class Passenger extends Man {

	private int id;

	public Passenger(String n, String s, int a) {
		name = n;
		surname = s;
		age = a;
		id = id + 1;
		System.out.println("Passenger " + n + " " + s + " (age " + a + ") created!");
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		id = i;
	}

}