package beertag.pages;

import testframework.PropertiesManager;
import testframework.core.BaseWebPage;

public class BaseBeerTagPage extends BaseWebPage {
    public BaseBeerTagPage(String pageSpecificUrl) {
        super(pageSpecificUrl);
    }

    @Override
    public String getBasePageUrl() { return PropertiesManager.getConfigProperties().getProperty("beertagBaseUrl"); }
}
