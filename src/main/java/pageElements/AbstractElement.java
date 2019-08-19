package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebElement;

import webDriver.WebDriverInstance;


public class AbstractElement {
	
	private By locator;
	
	public AbstractElement (By locator) {
		this.locator = locator;
	}

	/**
     * Instance method used to call static class method locateElement.
     * 
     * @return the web element found by locator
     */
    public RemoteWebElement getElement() {
        RemoteWebElement foundElement = null;
        try {
        	foundElement = (RemoteWebElement) WebDriverInstance.driver.findElement(locator);
        }catch(NoSuchElementException nse) {
        	System.out.println(nse.getMessage());
        }
        return foundElement;
    }
    
    public By getLocator() {
        return locator;
    }
}
