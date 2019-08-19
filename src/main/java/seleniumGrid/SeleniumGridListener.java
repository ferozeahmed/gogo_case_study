package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SeleniumGridListener implements ISuiteListener{

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		String hostToRun = suite.getParameter("hostToRun");
		String port = suite.getParameter("port");
		try {
			URL url = new URL("http://" + hostToRun + ":" + port + "/wd/hub");
			Grid.setGridUrl(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
