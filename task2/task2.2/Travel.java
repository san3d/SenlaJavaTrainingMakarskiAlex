
public class Travel {

	private int id;
	private String departurePlace;
	private String arrivalPlace;
	private Plane plane;

	public Travel(String dp, String ap){
		id++;
		departurePlace = dp;
		arrivalPlace = ap;
		System.out.println("Travel "+departurePlace+"-"+arrivalPlace+" created!");}

	public int getId() {
		return id;}

	public void setId(int i) {
		id = i;}

	public String getDeparturePlace() {
		return departurePlace;}

	public void setDeparturePlace(String depPlace) {
		departurePlace = depPlace;}

	public String getArrivalPlace() {
		return arrivalPlace;}

	public void setArrivalPlace(String arPlace) {
		arrivalPlace = arPlace;}

	public String getPlaces() {
		return departurePlace+"-"+arrivalPlace;}
	
	public void setPlane(Plane p) {
		plane = p;}
	
	public Plane getPlane() {
		return plane;}
	
}