package timeSheat;

import java.util.Scanner;

/**
 * 勤務日を取得して渡すクラス
 * @author y-fujii
 *
 */
public class WorkDay {
	/**
	 * 勤務日の入力を求めて値を渡すメソッド
	 * @param date 勤務日
	 * @return 勤務日をString型で返します
	 */
	public static String day(){
		System.out.println("日付(yyyy/MM/dd)を入力してください");
		Scanner sc = new Scanner(System.in);
		String date = sc.nextLine();
		while(!date.matches("^[0-9]{4}/[01]?[0-9]/[0123]?[0-9]$")){
			System.out.println("日付の入力形式が正しくありません。日付(yyyy/MM/dd)を入力しなおしてください。");
			date = sc.nextLine();
		}
		return date;
	}
}
