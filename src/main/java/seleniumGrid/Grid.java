package seleniumGrid;

import java.net.URL;

/**
 * 
 * @author feroze
 * 
 * getter/setter methods to store gridurl
 * static variable to provide gridurl
 *
 */
public class Grid {
	
	public static URL gridurl;
	public static String browserName;
	
	public static void setGridUrl(URL gridUrl) {
		gridurl = gridUrl;
	}
	
	public static URL getGridUrl() {
		return gridurl;
	}
	
	public static void setbrowserName(String browsername) {
		browserName = browsername;
	}
	
	public static String getbrowserName() {
		return browserName;
	}
}
