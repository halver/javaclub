package timeSheat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ColumnNumber {
	public static int columnNuber() {
		int cn = 0;
		// STEP 0:事前準備
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

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
					("select COUNT( * ) cnt from timesheat.timesheat;");
			// STEP 2-①-2 雛形に値を流し込みSQL文を組み立てて送信する
			ResultSet rs = pstmt.executeQuery();
			// STEP2-①-3 処理結果を判定する
			if(rs.next()) {
				cn = rs.getInt("cnt");
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
	        return cn+1;
	}
}
