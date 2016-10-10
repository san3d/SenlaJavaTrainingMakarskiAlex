

import java.util.ArrayList;

public class Equipage {
	private int id = 1;
	private ArrayList pilotsList=new ArrayList();
	private ArrayList personnelList=new ArrayList();

	public Equipage(){
		pilotsList.add("Pilot "+id);
		pilotsList.add("Pilot "+(id+1));
		personnelList.add("Personnel "+id);
		personnelList.add("Personnel "+(id+1));
		id++;
		System.out.println("Equipage "+pilotsList+" and "+personnelList+" created!");}

	public int getId() {
		return id;}

	public void setId(int i) {
		id = i;}

	public ArrayList getPilotsList() {
		return pilotsList;}

	public void setPilotsList(ArrayList pilList) {
		pilotsList = pilList;}

	public ArrayList getPersonnelList() {
		return personnelList;}

	public void setPersonnelList(ArrayList persList) {
		personnelList = persList;}
}