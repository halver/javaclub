package timeSheat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 現在DBに登録されているレコード数を取得するクラス
 * @author y-fujii
 *
 */
public class ColumnNumber {
	/**
	 * DBに登録されているレコード数を取得するメソッド
	 * @return レコード数cnに＋１した値ををint型で返します
	 * @param cn 登録されているレコード数
	 */
	public static int columnNuber() {
		int cn = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost/timesheat";
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement
					("select COUNT( * ) cnt from timesheat.timesheat;");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cn = rs.getInt("cnt");
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
	        return cn+1;
	}
}
