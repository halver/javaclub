package timeSheat;

public class Worktime {
	public static String time(){
		System.out.println("時刻(hh/dd)を入力してください");
		@SuppressWarnings("resource")
		String st = new java.util.Scanner(System.in).nextLine();
		while(!st.matches("^[012]?[0-9]:[0-9]?[0-9]$")){
			System.out.println("時刻の入力形式が正しくありません。時刻(hh:dd)を入力しなおしてください");
			st = new java.util.Scanner(System.in).nextLine();
		}
		return st;
	}
}
