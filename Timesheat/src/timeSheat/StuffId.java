package timeSheat;

import java.util.InputMismatchException;

public class StuffId {
	@SuppressWarnings("resource")
	public static int stuffid(){
		System.out.println("社員番号を入力してください");
		Integer si;
		for(;;){
			try{
				si = new java.util.Scanner(System.in).nextInt();
				while( Integer.toString(si).length()>6){
					System.out.println("社員番号が長過ぎます。6桁までの数字で入力してください");
					si = new java.util.Scanner(System.in).nextInt();
				}
				return si;
			}catch(InputMismatchException e){
				System.out.println("社員番号は6桁の数字で入力してください。");
			}
		}
	}
}