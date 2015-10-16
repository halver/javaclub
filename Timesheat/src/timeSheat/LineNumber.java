package timeSheat;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumber {
	public static int line() throws IOException{
		 LineNumberReader fin = new LineNumberReader(new FileReader("C:\\javaclub\\test.txt"));
	        @SuppressWarnings("unused")
			String aLine;

	        while(null!=(aLine = fin.readLine())){
	            ;
	        }
	        fin.close();
	        return fin.getLineNumber()+1;
	}
}
