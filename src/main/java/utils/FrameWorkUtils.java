package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameWorkUtils {
	
	public static String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date).toString(); 
	}

}
