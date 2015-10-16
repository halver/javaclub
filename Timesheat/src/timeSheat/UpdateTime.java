package timeSheat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateTime {
	public static String uptadetime() {
		Date uptime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(uptime);
	}
}