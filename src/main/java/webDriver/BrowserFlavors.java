package webDriver;

public enum BrowserFlavors {
	
	FIREFOX("firefox"),
	INTERNET_EXPLORER("ie"),
	CHROME("chrome");
	
	private String browser;
	
	private BrowserFlavors(String browsername) {
		this.browser = browsername;
	}
	
	public String getBrowser() {
        return this.browser;
    }
	
	public static BrowserFlavors getBrowserName(String browser) {
		BrowserFlavors flv = null;
		for(BrowserFlavors flavor : BrowserFlavors.values()) {
			if(flavor.getBrowser().equalsIgnoreCase(browser)) {
				flv = flavor;
				break;
			}
		}
		return flv;
	}

}
