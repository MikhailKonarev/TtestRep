import com.sun.istack.internal.localization.NullLocalizable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import sun.reflect.misc.FieldUtil;

import javax.jnlp.FileSaveService;
import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Class of Main page www.google.com
public class MainClass {
    private WebDriver driver;

    public MainClass(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args){

    }

    // XPath for the google search button
    private By searchButton = By.xpath("//div[@class=\"FPdoLc tfB0Bf\"]//input[@name=\"btnK\"]");
    // XPath for the google search text
    private By searchText = By.xpath("//input[@type=\"text\"]");

    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

    public void typeText(String searchtxt){
        driver.findElement(searchText).sendKeys(searchtxt);
    }

    // Try to find elements by XPath
    // result = true if 1 or more elements founded
    // result = false if no elements founded
    public boolean findElements(String xp){
        //WebElement element = driver.findElement(By.xpath("a[text()=\"Deutsche Telekom\"]"));
        List<WebElement> elements = driver.findElements(By.xpath(xp));
        return elements.size()>0;
    }

}