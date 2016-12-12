package task3_2;

public class Main {
	private static int i1;
	private static int i2;
	private static int i3;

	public static void main(String[] arg) {

		RandomNumber rn1 = new RandomNumber();
		i1 = rn1.getRandomNumber();
		System.out.println("i1=" + i1);

		RandomNumber rn2 = new RandomNumber();
		i2 = rn2.getRandomNumber();
		System.out.println("i2=" + i2);

		RandomNumber rn3 = new RandomNumber();
		i3 = rn3.getRandomNumber();
		System.out.println("i3=" + i3);

		Int_StringConverter int_StringConverter = new Int_StringConverter();
		String s1 = int_StringConverter.intToStringConverter(i1);

		String s2 = int_StringConverter.intToStringConverter(i2);

		Concatenator concatenator = new Concatenator();
		String s3 = concatenator.concatenator(s1, s2);

		System.out.println("i1 concat i2 = s3 ->" + s3);

		int n = int_StringConverter.StringToIntConverter(s3);

		System.out.println("s3 - i3 =" + (n - i3));
	}

}
