

public class Meteorologist {

	private boolean flightPermission;
	
	public Meteorologist(){
		flightPermission = true;
		System.out.println("Meteorologist created!");}
	
	public boolean getFlightPermission() {
		return flightPermission;}

	public void setFlightPermission(boolean permission) {
		permission = flightPermission;}
}