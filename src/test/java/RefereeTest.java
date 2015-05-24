import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class RefereeTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {

        this.driver = new FirefoxDriver();
    }

    @Test
    public void displaysCorrectWindowName() throws Exception {

        this.driver.get("https://nameless-hollows-9873.herokuapp.com/index");
        this.driver.findElement(By.id("search-bar")).sendKeys("Mari Maasik, ajakirjanik");
        this.driver.findElement(By.xpath("//span/button[text()='Mine']")).click();
        assertEquals("Soovitaja valikud", this.driver.getTitle());

    }

    @After
    public void tearDown() throws Exception {

        this.driver.quit();

    }

    @Test
    public void testGetRefereeByName() throws Exception {

    }

    @Test
    public void testGetRefereesByFirstNameLetter() throws Exception {

    }

    @Test
    public void testGetRefereesByFirstLetter() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testSaveRefereeDataToDataBase() throws Exception {

    }
}