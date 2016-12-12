package task3_1;

public class Main {
	public static void main(String args[]){
		String s = "Any words in my sentence!";
		Word word = new Word(s); 
		Spliter spliter = new Spliter();
		String[] splitString = spliter.toSplit(word);
		ArrayToString arrayString = new ArrayToString();
		String r = arrayString.arrayToString(splitString);
		System.out.println(r);
	}
}
