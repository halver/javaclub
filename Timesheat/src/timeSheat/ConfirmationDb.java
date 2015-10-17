package timeSheat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConfirmationDb {

	public void confirmation() throws IOException{
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
					("select * from timesheat");
			// STEP 2-①-2 雛形に値を流し込みSQL文を組み立てて送信する
			ResultSet rs = pstmt.executeQuery();
			// STEP2-①-3 処理結果を判定する
			System.out.println("項番　社員番号　勤務日　開始日時　終了日時　更新日時");
			while(rs.next()) {
				System.out.printf("%d %s %s %s %s %s\n",rs.getInt("id"),rs.getString("employee_id"),rs.getString("working_day")
						,rs.getString("start_time"),rs.getString("end_time"),rs.getString("updata_time"));
			}
			rs.close();
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
	}
}