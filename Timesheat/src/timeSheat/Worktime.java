package timeSheat;

/**
 * 勤務時刻入力クラス<br>
 * このクラスは勤務時間の入力を求め入力値を返します
 */
public class Worktime {
	/**
	 * 勤務時刻を取得して値渡すメソッド
	 */
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
