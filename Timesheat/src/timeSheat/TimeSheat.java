package timeSheat;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class TimeSheat {

	public static void main(String[] args) throws IOException{
		for(;;){
			char i;
			FileWriter fw = new FileWriter("C:\\javaclub\\test.txt", true);
			int ln = LineNumber.line();// 行番号を取得
			Integer stuffid = StuffId.stuffid();// 社員番号を取得
			String d = WorkDay.day();// 日付を取得
			String st = Worktime.time();// 開始時間を取得
			String et = Worktime.time();// 終了時間を取得
			String ut = UpdateTime.uptadetime();// 更新時間を取得
			fw.write("項番：" + ln + " 社員番号：" + stuffid + " 日付：" + d +
					" 開始時刻：" + st + " 終了時刻：" + et + " 更新時間："+ ut +"\n");
			fw.flush();
			fw.close();
			System.out.println("入力が完了しました。");
			for(;;){
				System.out.println("続けて入力しますか? y/n");
				BufferedReader yn=new BufferedReader(new InputStreamReader(System.in));
				i = (char) yn.read();
				if(i == 'y' || i == 'n' )
					break;
			}
			if (i == 'n'){
				System.out.println("入力を終了します。");
				break;
			}
		}

		/*BufferedReader br = new BufferedReader(new FileReader("C:\\javaclub\\test.txt"));

		  String str = br.readLine();
		  while(str != null){
		    System.out.println(str);

		    str = br.readLine();
		  }

		  br.close();*/
	}

}

