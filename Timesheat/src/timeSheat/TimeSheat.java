package timeSheat;

import java.io.IOException;
public class TimeSheat {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println("操作を選択してください。");
		System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
		int n = new java.util.Scanner(System.in).nextInt();
		while(n!=5){
			switch(n) {
			case 1:
				InputDb in = new InputDb();
				in.input();
				break;
			case 2:
				UpdataDb up = new UpdataDb();
				up.updata();
				break;
			case 3:
				DeleatDb del = new DeleatDb();
				del.deleat();
				break;
			case 4:
				ConfirmationDb con = new ConfirmationDb();
				con.confirmation();
				break;
			}
			System.out.println("操作を選択してください。");
			System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
			n = new java.util.Scanner(System.in).nextInt();
		}
		System.out.println("操作を終了します。");
	}
}