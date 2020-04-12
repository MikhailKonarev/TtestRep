import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

// Tests of MainClass
public class MainClassTest {
    private WebDriver driver;
    private MainClass googleMain;
    //@BeforeClass
    //public void setupGlobal(){
    //}

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "E:\\Javatests\\testm1\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        googleMain = new MainClass(driver);
    }

    // Search page title test
    @Test
    //@Ignore
    public void searchPageTitleTest(){
        googleMain.typeText("T-Systems");
        googleMain.clickSearch();
        String pageTitle = driver.getTitle();
        Assert.assertEquals("T-Systems - Поиск в Google",pageTitle);

    }

    // Search for Phone number text
    @Test
    //@Ignore
    public void searchPhoneText(){
        googleMain.typeText("T-Systems");
        googleMain.clickSearch();
        boolean isFound;
        isFound = googleMain.findElements("//span[text()=\"8 (473) 200-15-30\"]");
        Assert.assertTrue(isFound);
    }

    // Search for the text with t-systems site
    @Test
    //@Ignore
    public void searchTextTadr(){
        googleMain.typeText("T-Systems");
        googleMain.clickSearch();
        //System.out.println("Test Started");
        boolean isFound;
        isFound = googleMain.findElements("//cite[text()=\"www.t-systems.com › ...\"]");
        Assert.assertTrue(isFound);
    }

    @After
    public void afterTest(){
        driver.quit();
    }
}
