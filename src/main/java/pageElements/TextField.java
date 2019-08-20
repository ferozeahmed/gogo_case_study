package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * TextField class
 * @author ferahmed
 *
 */
public class TextField extends AbstractElement{
	
	/**
	 * <h1>TextField Construction method</h1>
	 * <b>usage:</b>
	 * private TextField txtTitle = new TextField("//input[@id='title']")
	 * 
	 * @param locator
	 * 			- A locator object of By class
	 */
	public TextField(By locator) {
        super(locator);
    }
	
	public void type(String value) {
		RemoteWebElement element = getElement();
		element.clear();
		element.sendKeys(value);
	}
}
