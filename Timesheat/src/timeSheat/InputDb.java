package timeSheat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * DBにレコードを追加するクラス
 */
public class InputDb {
/**
 * 取得した値をDBにinsertするメソッド
 * @param cn 登録済みのカラム数
 * @param employeeid 社員番号
 * @param d 勤務日付
 * @param st 勤務開始時刻
 * @param et 勤務終了時刻
 * @throws IOException
 */
	public void input() throws IOException{
		for(;;){
			char i;
			int cn = ColumnNumber.columnNuber();// 登録済みのカラム数を取得
			Integer employeeid = EmployeeId.employeeId();// 社員番号を取得
			String d = WorkDay.day();// 日付を取得
			String st = Worktime.startTime();// 開始時間を取得
			String et = Worktime.endTime();// 終了時間を取得
			Connection con = null;

			try {
				String url = "jdbc:mysql://localhost/timesheat";
				String user = "root";
				String password = "root";
				con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement
						("insert into timesheat.timesheat (id,employee_id,working_day,start_time,end_time) values (?,?,?,?,?)");
				pstmt.setInt(1, cn);
				pstmt.setInt(2, employeeid);
				pstmt.setString(3, d);
				pstmt.setString(4, st);
				pstmt.setString(5, et);
				int r = pstmt.executeUpdate();
				if(r != 0){
					System.out.println("レコードを追加しました");
				}
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			} finally {
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