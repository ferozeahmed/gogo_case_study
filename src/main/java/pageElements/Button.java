package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public class Button extends AbstractElement{

	public Button(By locator) {
		super(locator);
	}

	public void clickButton() {
		RemoteWebElement element = getElement();
		element.click();
	}
}
