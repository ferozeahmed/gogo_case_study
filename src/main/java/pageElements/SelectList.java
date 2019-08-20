package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Select class
 * @author ferahmed
 *
 */
public class SelectList extends AbstractElement{
	
	public SelectList(By locator) {
		super(locator);
	}
	
	public void selectByVisibleText(String visibleText) {
		RemoteWebElement element = getElement();
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectByIndex(int index) {
		RemoteWebElement element = getElement();
		Select select = new Select(element);
		select.selectByIndex(index);
	}

}
