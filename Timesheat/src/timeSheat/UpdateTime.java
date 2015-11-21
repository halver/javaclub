package timeSheat;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 現在時刻をシステムから取得し更新日時として渡すクラス
 * @author y-fujii
 *
 */
public class UpdateTime {
	/**
	 * 現在時刻を取得し(yyyy/MM/dd HH:mm:ss)の形式にフォーマットして値を渡すメソッド
	 * @param uptime 更新日時
	 * @return (yyyy/MM/dd HH:mm:ss)の形式にフォーマットされたDate型の値を渡します
	 */
	public static String uptadetime() {
		Date uptime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(uptime);
	}
}