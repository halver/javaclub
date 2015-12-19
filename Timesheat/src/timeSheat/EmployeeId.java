package timeSheat;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 社員番号を取得するクラス
 * @author y-fujii
 * @param ei 社員番号
 */
public class EmployeeId {
	/**
	 * 社員番号の入力を求め取得した社員番号を返すメソッド
	 * @return Integer型の社員番号を返します
	 */
	public static int employeeId(){
		System.out.println("社員番号を入力してください");
		int ei;
		Scanner sc = new Scanner(System.in);
		while(true){
			try{
				ei = sc.nextInt();
				while( Integer.toString(ei).length()>6){
					System.out.println("社員番号が長過ぎます。6桁までの数字で入力してください");
					ei = sc.nextInt();
				}
				return ei;
			}catch(InputMismatchException e){
				System.out.println("社員番号は6桁の数字で入力してください。");
			}
		}
	}
}