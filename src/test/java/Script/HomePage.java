package Script;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class HomePage {


    @Test
    public void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\Project\\workSpace\\E2EProject\\chromedriver.exe");
//        driver = new ChromeDriver();
        // Instantiate a ChromeDriver class.
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        WebDriver driver = new ChromeDriver(desiredCapabilities);
        // Maximize the browser
        driver.manage().window().maximize();
        // Launch Website
        driver.get("https://www.desuicoinflip.io");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//*[@placeholder='Input the amount of SUI you want to deposit']")).sendKeys("0.00001");
        int i=0;

        for(i=0; i<1500; i++){
//            Thread.sleep(3000);
            System.out.println("========NUMBER: "+i+" ==============");
            driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div/div/div/div[2]/div/main/div/button")).click();
            Thread.sleep(800);
            try {
                ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(windows.get(windows.size()-1));
                Thread.sleep(100);
                driver.findElement(By.xpath("/html/body/div/div/div[1]/div/main/div/div[2]/div/button[2]")).click();
                driver.switchTo().window(windows.get(0));
                Thread.sleep(400);
            }catch (Exception e){
                try {
                ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(windows.get(windows.size()-1));
                Thread.sleep(100);

                driver.findElement(By.xpath("/html/body/div/div/div[1]/div/main/div/div[2]/div/button[2]")).click();
                driver.switchTo().window(windows.get(0));
                Thread.sleep(400);
                }catch (Exception ex){}
            }
        }

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.querySelector('#main > div > div:nth-child(4) > div > div > shopee-banner-popup-stateful').shadowRoot.querySelector('div > div > div > div > div').click()");
//        js.executeScript("document.querySelector('#app > div > div:nth-child(1) > div > div.shopee-floating-icon > div').click()");
       String a = "change to remote";
//        System.out.println(a.toString());



    }


}
