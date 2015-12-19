package timeSheat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UpdataDb {

	public void updata() throws IOException{
		while(true){
			char i;
			System.out.println("更新元データを検索します。");
			Integer employeeid = EmployeeId.employeeId();// 社員番号を取得
			String d = WorkDay.day();// 日付を取得
			Connection con = null;

			try {
				// STEP 1:データベースの接続
				String url = "jdbc:mysql://localhost/timesheat";
				String user = "root";
				String password = "root";
				con = DriverManager.getConnection(url, user, password);
				// STEP 2:SQL送信処理
				// STEP 2-①-1 送信すべきSQL文の雛形を準備
				PreparedStatement pstmt1 = con.prepareStatement
						("select * from timesheat where employee_id=? and working_day=?");
				// STEP 2-①-2 雛形に値を流し込みSQL文を組み立てて送信する
				pstmt1.setInt(1, employeeid);
				pstmt1.setString(2, d);
				ResultSet rs1 = pstmt1.executeQuery();
				// STEP2-①-3 処理結果を判定する
				if(rs1.next()) {
					System.out.println("現在の登録内容です");
					System.out.println("項番　社員番号　勤務日　開始日時　終了日時　更新日時");
					System.out.printf("%d %s %s %s %s %s\n",rs1.getInt("id"),rs1.getString("employee_id"),rs1.getString("working_day")
							,rs1.getString("start_time"),rs1.getString("end_time"),rs1.getString("updata_time"));
				} else {
					System.out.println("この社員番号、日付でのデータは存在しません。");
				}
				rs1.close();
				pstmt1.close();// 後片付け
				String st = Worktime.startTime();// 開始時間を取得
				String et = Worktime.endTime();// 終了時間を取得
				PreparedStatement pstmt2 = con.prepareStatement
						("update timesheat set start_time = ?, end_time = ? where employee_id=? and working_day=?");
				pstmt2.setString(1, st);
				pstmt2.setString(2, et);
				pstmt2.setInt(3, employeeid);
				pstmt2.setString(4, d);
				int r = pstmt2.executeUpdate();
				// STEP2-①-3 処理結果を判定する
				if(r != 0){
					System.out.println("レコードを追加しました");
				}
				pstmt2.close();// 後片付け
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
			while(true){
				System.out.println("続けて更新しますか? y/n");
				BufferedReader yn=new BufferedReader(new InputStreamReader(System.in));
				i = (char) yn.read();
				if(i == 'y' || i == 'n' )
					break;
			}
			if (i == 'n'){
				System.out.println("更新を終了します。");
				break;
			}
		}
	}
}