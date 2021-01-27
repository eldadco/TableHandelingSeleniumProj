package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.HomePage.*;
import java.util.HashMap;


public class HomePageTest extends BaseTest {
    HomePageActions homePageActions;
    private HashMap<String, Integer> tableColumns = new HashMap<>();
    private String searchColumn ;
    private String searchText;
    private String returnColumnText;
    private String expectedText;

    public HomePageTest() {
        this.homePageActions = new HomePageActions();

        this.tableColumns = new HashMap<>();
        this.tableColumns.put("Company", 1);
        this.tableColumns.put("Contact", 2);
        this.tableColumns.put("Country", 3);


    }

    @BeforeMethod
    public void configData() {
        this.searchColumn = this.inputs.get("searchColumn").toString();
        this.searchText = this.inputs.get("searchText").toString();
        this.returnColumnText = this.inputs.get("returnColumnText").toString();
        this.expectedText = this.inputs.get("expectedText").toString();
    }

    @Test(description = "Verify table values in the first way")
    public void testTheFirstWay() {
        Assert.assertTrue(this.homePageActions
                .verifyTableCellTextFirstWay(this.homePageActions.getTableElement(),this.tableColumns.get(this.searchColumn),this.searchText,this.tableColumns.get(this.returnColumnText),this.expectedText), "Verify the expected text equals the actual text");

    }

    @Test(description = "Verify table values in the second way - access via xpath")
    public void testTheSecondWay() {

        Assert.assertTrue(this.homePageActions.verifyTableCellTextSecondWay(this.homePageActions.getTableElement(), this.tableColumns.get(this.searchColumn),this.searchText,this.tableColumns.get(this.returnColumnText),this.expectedText), "Verify the expected text equals the actual text");

    }

}
