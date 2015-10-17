package timeSheat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class inputdb {

	public void input() throws IOException{
		for(;;){
			char i;
			int cn = ColumnNumber.columnNuber();// 登録済みのカラム数を取得
			Integer employeeid = EmployeeId.employeeId();// 社員番号を取得
			String d = WorkDay.day();// 日付を取得
			String st = Worktime.time();// 開始時間を取得
			String et = Worktime.time();// 終了時間を取得
			Connection con = null;

			try {
				// STEP 1:データベースの接続
				String url = "jdbc:mysql://localhost/timesheat";
				String user = "root";
				String password = "root";
				con = DriverManager.getConnection(url, user, password);
				// STEP 2:SQL送信処理
				// STEP 2-①-1 送信すべきSQL文の雛形を準備
				PreparedStatement pstmt = con.prepareStatement
						("insert into timesheat.timesheat (id,employee_id,working_day,start_time,end_time) values (?,?,?,?,?)");
				// STEP 2-①-2 雛形に値を流し込みSQL文を組み立てて送信する
				pstmt.setInt(1, cn);
				pstmt.setInt(2, employeeid);
				pstmt.setString(3, d);
				pstmt.setString(4, st);
				pstmt.setString(5, et);
				int r = pstmt.executeUpdate();
				// STEP2-①-3 処理結果を判定する
				if(r != 0){
					System.out.println("レコードを追加しました");
				}
				pstmt.close();// 後片付け
			}catch(SQLException e) {
				e.printStackTrace();
			} finally {
				// STEP 3:データベース接続の切断
				if(con != null) {
					try {
						con.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
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
	}
}