package timeSheat;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * 勤務時刻入力クラス<br>
 * このクラスは勤務時間の入力を求め入力値を返します
 */
public class Worktime {

	static Logger logger = Logger.getLogger(Worktime.class);
	/**
	 * 開始時間を取得
	 * @return time()から受け取った値ををString型で返す
	 */
	public static String startTime(){
		System.out.println("開始時刻(hh/dd)を入力してください");
		String st = time();
		return st;
	}
	/**
	 * 終了時間を取得
	 * @return time()から受け取った値ををString型で返す
	 */
	public static String endTime(){
		System.out.println("終了時刻(hh/dd)を入力してください");
		String et = time();
		return et;
	}
	/**
	 * 勤務時刻を取得
	 * @return 入力された時刻をString型で返す
	 */
	public static String time(){
		logger.debug("時刻の取得を開始します。");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String time = sc.nextLine();
		while(!time.matches("^[012]?[0-9]:[0-9]?[0-9]$")){
			logger.info("正しくない形式の入力を検知しました");
			System.out.println("時刻の入力形式が正しくありません。時刻(hh:dd)を入力しなおしてください");
			time = sc.nextLine();
		}
		logger.debug("取得した時刻を渡します。");
		return time;
		}
}
