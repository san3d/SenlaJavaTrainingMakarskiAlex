package task3_3;

import java.util.HashSet;
import java.util.Set;

public class Firm {
	private int totalSalary;
	private Set<Employ> set = new HashSet<Employ>();
	private String firmName;

	public Firm(String firmName) {
		this.firmName=firmName;
		System.out.println("Firm " + firmName + " created!");
	}

	public void addEmploy(Employ person) {
		set.add(person);
		System.out.println("Employer "+person.getName()+" work on "+firmName);
	}

	public Set<Employ> getSet() {
		return set;
	}

	public void calculateSummarySalary() {
		int n = 0;
		System.out.println("Calculating salary :");
		for (Employ s : set) {
			n = n + s.getSalary();
			System.out.println(s.getSalary());
		}
		this.totalSalary = n;
	}

	public int getSummarySalary() {
		return totalSalary;
	}

}
