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

public class RefereeListServletTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        this.driver = new FirefoxDriver();
        this.driver.get("https://nameless-hollows-9873.herokuapp.com/soovitajate-nimekiri");
        this.driver.findElement(By.id("alphabetically")).click();
        this.driver.findElement(By.id("M")).click();
    }

    @Test
    public void displaysCorrectUrlWhenMIsClicked() throws Exception {

        assertEquals("https://nameless-hollows-9873.herokuapp.com/soovitajate-nimekiri/M", this.driver.getCurrentUrl());
    }

    @Test
    public void testLinks() throws Exception {

        List<String> Linkarray = new ArrayList<String>();

        List<WebElement> LinkList = this.driver.findElement(By.id("tablediv")).findElements(By.tagName("a"));

        for(WebElement link: LinkList) {
            String links = link.getText();
            Linkarray.add(links);
        }
        for(String linkToTest: Linkarray){
            this.driver.findElement(By.linkText(linkToTest)).click();
            assertEquals("Soovitaja valikud", this.driver.getTitle());
            this.driver.navigate().back();
        }
    }

    @Test
    public void displaysCorrectUrlWhenBackIsClicked() throws Exception {

        this.driver.navigate().back();
        assertEquals("https://nameless-hollows-9873.herokuapp.com/soovitajate-nimekiri", this.driver.getCurrentUrl());
    }



    @After
    public void tearDown() throws Exception {

        this.driver.quit();

    }

}