import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FaqPage extends AbstractPageObject {

    public FaqPage(WebDriver driver) {
        super(driver);
    }
    
    //By menuBarLocator = By.cssSelector("div#mainnavi");
    private String xpathExpression = "//div[@id='column_left']/h1[contains(text(), 'Frequently')]";
    				
    @Override
    protected By getUniqueElement() {
    	//div id="column_left">    	<h1>Frequently Asked Questions regarding ICDP</h1>
        return By.xpath(xpathExpression); 
        // By.cssSelector(".youarehere #nav-questions");
    }

    By faqTabSelectedLocator = By.xpath(xpathExpression); //By.cssSelector(".youarehere #nav-questions");
	
	
    By paragraphLocator = By.xpath("//div[@id='column_left']//p");

    public Boolean isFaqTabDisplayed() {
        List<WebElement> usersTab = driver.findElements(paragraphLocator);
        return usersTab.size() > 0;
    }
}
