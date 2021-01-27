package Tests;

import PageUtills.Locators;
import PageUtills.XmlUtills.InputsData;
import Pages.DriverUtills.DriverSingleton;
import Pages.HomePage.HomePageLocators;
import SeleniumInfra.SeleniumInfraStructure;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.HashMap;

public abstract class BaseTest {
    protected final SeleniumInfraStructure seleniumInfra = DriverSingleton.getInstance().seleniumInfra;
    public static int testId= 1;
    InputsData inputsData = new InputsData();
    protected int numOfTests  = inputsData.getNumOfTests();
    protected HashMap inputs ;


    @BeforeClass
    public void beforeClassMethod() {
        this.seleniumInfra.getUrl("http://www.w3schools.com/html/html_tables.asp");
        this.inputs = inputsData.getDataByTestId(testId);
    }


    @BeforeMethod
    public void beforeMethod()
    {
        this.inputs = inputsData.getDataByTestId(testId);
    }
    @AfterMethod
    public void afterTestActions() {
        testId++;

    }
    @AfterSuite
    public void afterSuiteMethod() {
        this.seleniumInfra.close();
        this.seleniumInfra.quit();
    }

}
