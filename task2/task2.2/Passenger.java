

public class Passenger extends Man {

	private int id;
	private String passportNumber;
	private Plane plane;
	public Passenger(String n, String s, int a){
		name = n;
		surname = s;
		age = a;
		System.out.println("Passenger "+n+" "+s+" (age "+a+") created!");
		}

	public int getId() {
		return id;}

	public void setId(int i) {
		id = i;}

	public String getPassportNumber() {
		return passportNumber;}

	public void setPassportNumber(String number) {
		passportNumber = number;}

	public void setPlane(Plane p) {
		plane = p;}
	
	public Plane getPlane() {
		return plane;}
	
}