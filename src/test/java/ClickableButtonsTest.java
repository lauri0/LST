/**
 * Created by siiri on 10/05/15.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClickableButtonsTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        this.driver = new FirefoxDriver();
        this.driver.get("https://nameless-hollows-9873.herokuapp.com/index");
    }


    @Test
    public void testLinks() throws Exception {

        List<String> Linkarray = new ArrayList<String>();
        List<String> pageNames = new ArrayList<String>();
        pageNames.add("Poliitiline soovitusleht");
        pageNames.add("Soovitajate nimekiri");
        pageNames.add("Sign in - Google Accounts");
        pageNames.add("Sign in - Google Accounts");
        pageNames.add("Soovitaja kutsumine");
        pageNames.add("Statistika");


        List<WebElement> LinkList = this.driver.findElements(By.tagName("a"));

        for(WebElement link: LinkList) {
            String links = link.getText();
            Linkarray.add(links);
        }
        for(int i=0; i < Linkarray.size(); i++){
            this.driver.findElement(By.linkText(Linkarray.get(i))).click();
            assertEquals(pageNames.get(i), this.driver.getTitle());
            this.driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {

        this.driver.quit();

    }
}
