package SeleniumInfra;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumInfraStructure {
    protected WebDriver driver;
    protected WebDriverWait waitForElems;
    protected JavascriptExecutor js;
    protected ExpectedConditions conditions;

    public SeleniumInfraStructure() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\p0028867\\Downloads\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.waitForElems = new WebDriverWait(this.driver, 40);
        this.js = (JavascriptExecutor) driver;

    }

    public void getUrl(String url) {
        try {
            this.driver.get(url);
            System.out.println("Selenium-infra success message:\t The requested site has opened successfully");
            this.driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Selenium-infra error : \t" + e.toString());
        }
    }

    public boolean isElementExists(String locatorType, String locatorValue) {
        if (this.findElem(locatorType, locatorValue,null) != null) {
            System.out.println("The element has found successfully");
            return true;
        } else {
            return false;
        }
    }


    public Boolean urlValidation(String url) {
        try {
            Thread.sleep(5000);
            if (this.driver.getCurrentUrl().contains(url)) {
                System.out.println("SeleniumInfra success message : the current url is: " + url);
                return true;
            } else {
                System.out.println("SeleniumInfra failed message : the current url does not contain: " + url);
                System.out.println("The current url is " + this.driver.getCurrentUrl());
                return false;
            }
        } catch (Exception excep) {
            System.out.println("SeleniumInfra exception message : " + excep.toString());
            return false;
        }
    }

    public WebElement findElem(String locatorType, String locatorValue, WebElement fromElement) {

        try {
            if (fromElement == null) {
                switch (locatorType) {
                    case "class":
                        return this.driver.findElement(By.className(locatorValue));
                    case "id":
                        return this.driver.findElement(By.id(locatorValue));
                    case "xpath":
                        return this.driver.findElement(By.xpath(locatorValue));
                    case "css":
                        return this.driver.findElement(By.cssSelector(locatorValue));
                    case "tag":
                        return this.driver.findElement(By.tagName(locatorValue));
                    default:
                        System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                        break;
                }}
                      else{
                    switch (locatorType) {
                        case "class":
                            return fromElement.findElement(By.className(locatorValue));
                        case "id":
                            return fromElement.findElement(By.id(locatorValue));
                        case "xpath":
                            return fromElement.findElement(By.xpath(locatorValue));
                        case "css":
                            return fromElement.findElement(By.cssSelector(locatorValue));
                        case "tag":
                            return fromElement.findElement(By.tagName(locatorValue));
                        default:
                            System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                            break;
                    }
            }

        } catch (InvalidSelectorException excep) {
            System.out.println("Selenium-infra error : \t" + "invalid selector exception by locatorType: " + locatorType + " and locator value : " + locatorValue);
        } catch (NoSuchElementException excep) {
            System.out.println("Selenium-infra error : No such Element Exception by locatorType: "
                    + locatorType + " and locator value : " + locatorValue);

        } catch (ElementNotVisibleException excep) {

            System.out.println("Selenium-infra error : element not visible exception by locatorType: " + locatorType + " and locator value : " + locatorValue);
        }
        return null;

    }

    public List<WebElement> findElementListBy(String locatorType, String locatorValue, WebElement fromElement) {

        try {
            if (fromElement == null) {
                switch (locatorType) {
                    case "class":
                        return this.driver.findElements(By.className(locatorValue));
                    case "id":
                        return this.driver.findElements(By.id(locatorValue));
                    case "xpath":
                        return this.driver.findElements(By.xpath(locatorValue));
                    case "css":
                        return this.driver.findElements(By.cssSelector(locatorValue));
                    case "tag":
                        return this.driver.findElements(By.tagName(locatorValue));
                    default:
                        System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                        break;
                }
            } else {
                switch (locatorType) {
                    case "class":
                        return fromElement.findElements(By.className(locatorValue));
                    case "id":
                        return fromElement.findElements(By.id(locatorValue));
                    case "xpath":
                        return fromElement.findElements(By.xpath(locatorValue));
                    case "css":
                        return fromElement.findElements(By.cssSelector(locatorValue));
                    case "tag":
                        return fromElement.findElements(By.tagName(locatorValue));
                    default:
                        System.out.println("Selenium-infra error message:\tThe locator type is not correct");
                        break;
                }
            }
        } catch (NoSuchElementException | ElementNotVisibleException except) {
            System.out.println("Selenium-infra error : \t" + except.toString());

            return null;
        }
        return null;

    }


    public String getTextFromElement(String locatorType, String locatorValue, WebElement elem,WebElement fromElement) {
        try {
            if (elem == null) {
                elem = this.findElem(locatorType, locatorValue,fromElement);

            }
            return elem.getText();
        } catch (Exception excep) {
            System.out.println("seleniumInfra error " + excep.toString());
            return "getTextFromElement function failed";
        }
    }

    public void close() {

        this.driver.close();
    }

    public void quit() {
        this.driver.quit();
    }
}
