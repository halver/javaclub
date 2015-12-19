package timeSheat;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
public class TimeSheat {
	static Logger logger = Logger.getLogger(TimeSheat.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		logger.info("起動しました。");
		System.out.println("操作を選択してください。");
		System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
		int n = new java.util.Scanner(System.in).nextInt();
		while(n!=5){
			switch(n) {
			case 1:
				logger.debug("レコードを追加します。");
				InputDb in = new InputDb();
				in.input();
				logger.debug("レコードを追加しました。");
				break;
			case 2:
				logger.debug("レコードを更新します。");
				UpdataDb up = new UpdataDb();
				up.updata();
				logger.debug("レコードを更新しました");
				break;
			case 3:
				logger.debug("レコードを削除します。");
				DeleteDb del = new DeleteDb();
				del.delete();
				logger.debug("レコードを削除しました。");
				break;
			case 4:
				logger.debug("レコードを確認します。");
				ConfirmationDb con = new ConfirmationDb();
				con.confirmation();
				logger.debug("レコードを確認しました。");
				break;
			}
			System.out.println("操作を選択してください。");
			System.out.println("1:追加　2:更新　3:削除　4:確認　5:終了");
			n = new java.util.Scanner(System.in).nextInt();
		}
		System.out.println("操作を終了します。");
		logger.info("終了しました。");
	}
}