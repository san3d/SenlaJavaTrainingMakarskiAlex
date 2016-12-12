package task3_2;

public class Int_StringConverter {

	public String intToStringConverter(int i) {
		String s = Integer.toString(i);
		return s;
	}
	
	public int StringToIntConverter(String s) {
		int i = Integer.valueOf(s);
		return i;
	}
}
