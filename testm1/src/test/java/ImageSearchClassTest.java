import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ImageSearchClassTest {
    private WebDriver driver;
    private ImageSearchClass googleImage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "E:\\Javatests\\testm1\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://images.google.com/?gws_rd=ssl");
        googleImage = new ImageSearchClass(driver);
    }

    // Search page title test
    @Test
    //@Ignore
    public void searchPageTitleTest(){
        googleImage.findRabbitImage();
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Поиск в Google",pageTitle);
    }

    // Search for the link зверополис как нарисовать зайца
    @Test
    //@Ignore
    public void searchLinkZvero(){
        googleImage.findRabbitImage();
        boolean isFound;
        isFound = googleImage.findElements("//a[text()=\"зверополис как нарисовать зайца\"]");
        Assert.assertTrue(isFound);
    }

    @After
    public void afterTest(){
        driver.quit();
    }
}
