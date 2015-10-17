package timeSheat;

import java.io.IOException;
public class TimeSheat {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		System.out.println("操作を選択してください。");
		System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
		int n = new java.util.Scanner(System.in).nextInt();
		for(;;) {
			if(n==1){
				InputDb in = new InputDb();
				in.input();
				System.out.println("操作を選択してください。");
				System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
				n = new java.util.Scanner(System.in).nextInt();
			}else if (n==2){
				UpdataDb up = new UpdataDb();
				up.updata();
				System.out.println("操作を選択してください。");
				System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
				n = new java.util.Scanner(System.in).nextInt();
			}else if (n==3){
				DeleatDb up = new DeleatDb();
				up.deleat();
				System.out.println("操作を選択してください。");
				System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
				n = new java.util.Scanner(System.in).nextInt();
			}else if (n==4){
				ConfirmationDb con = new ConfirmationDb();
				con.confirmation();
				System.out.println("操作を選択してください。");
				System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
				n = new java.util.Scanner(System.in).nextInt();
			}else if (n==5){
				System.out.println("操作を終了します。");
				break;
			}else{
				System.out.println("操作を選択してください。");
				System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
				n = new java.util.Scanner(System.in).nextInt();
			}
		}
	}
}