package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * Label class
 * @author ferahmed
 *
 */
public class Label extends AbstractElement{

	public Label(By locator) {
		super(locator);
	}
	
	public String getLabelText() {
		RemoteWebElement element = getElement();
		return element.getText();
	}

}
