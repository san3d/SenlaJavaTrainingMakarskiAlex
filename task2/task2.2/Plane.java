

import java.util.HashSet;
import java.util.Set;

public class Plane {

	private int id = 222;
	private String boardNumber;
	private Equipage equipageId;
	private Set<Travel> travelId = new HashSet<Travel>();
	private Set<Passenger> passengers = new HashSet<Passenger>();
	public Plane(String s){
		id++;
		boardNumber=s;
		System.out.println("Plane Board "+boardNumber+" created!");}

	public int getId() {
		return id;}
	
	public void setId(int i) {
		id = i;}
	
	public String getBoardNumber() {
		return boardNumber;}

	public void setBoardNumber(String bn) {
		boardNumber = bn;}

	public Equipage getEquipageId() {
		return equipageId;}

	public void setEquipageId(Equipage e) {
		equipageId = e;}

	public Set<Travel> getTravelId() {
		return travelId;}
	
	public void setTravelId(Travel newTravelId) {
		travelId.add(newTravelId);
		newTravelId.setPlane(this);}	
	
	public void getPassengers() {
		for (Passenger s : passengers)
		    System.out.println(s.getName()+" "+s.getSurname()+" ("+s.getAge()+")");
		}

	public void addPassengers(Passenger newPassenger) {
		passengers.add(newPassenger);
		newPassenger.setPlane(this);}

	public void deletePassenger(int i) {
		passengers.remove(i);}

	public int checkPassengersQuantity() {
		return passengers.size();
		}

	public void toFlight(Meteorologist permission){
		if (permission.getFlightPermission())
		System.out.println("Полёт разрешён!");
		else System.out.println("Полёт запрещён!");
	}
}