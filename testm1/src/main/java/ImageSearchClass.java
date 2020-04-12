import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImageSearchClass {
    private WebDriver driver;

    public ImageSearchClass(WebDriver driver) {
        this.driver = driver;
    }

    // Try to find elements by XPath
    // result = true if 1 or more elements founded
    // result = false if no elements founded
    public boolean findElements(String xp){
        List<WebElement> elements = driver.findElements(By.xpath(xp));
        return elements.size()>0;
    }

    // XPath for the google image search button
    private By imageSearchButton = By.xpath("//div[@aria-label=\"Поиск по картинке\"]");
    // XPath for the Load image link
    private By loadImage = By.xpath("//a[text()=\"Загрузить файл\"]");
    // XPath for the loaded file
    private By loadFile = By.xpath("//input[@type='file']");
    // Way for the file
    private String way = "D:\\r.jpg";

    public void findRabbitImage(){
        driver.findElement(imageSearchButton).click();
        driver.findElement(loadImage).click();
        driver.findElement(loadFile).sendKeys(way);

        driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
    }



    public static void main(String[] args){
      /*  System.setProperty("webdriver.gecko.driver", "E:\\Javatests\\testm1\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //driver.manage().window().maximize();
        driver.get("https://images.google.com/?gws_rd=ssl");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@aria-label=\"Поиск по картинке\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"Загрузить файл\"]")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("r.jpg");
        //System.out.println("!!");
        // driver.quit();
*/

    }
}
