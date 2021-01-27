package Pages.HomePage;

import PageUtills.Locators;
import Pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class HomePageActions extends BasePage {
    private HashMap<String, Integer> tableColumns;

    public HomePageActions() {}


    public WebElement getTableElement() {
        return this.seleniumInfra.findElem(Locators.XPATH.getLocator(), HomePageLocators.table, null);

    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {

        try {
            List<WebElement> rows = this.seleniumInfra.findElementListBy(Locators.XPATH.getLocator(), HomePageLocators.rows, table);

            for (int i = 1; i < rows.size(); i++) {
                List<WebElement> cells = this.seleniumInfra.findElementListBy(Locators.XPATH.getLocator(), HomePageLocators.cellsInRows, rows.get(i));
                if (this.seleniumInfra.getTextFromElement(null, null, cells.get(searchColumn - 1), null).equals(searchText)) {
                    return this.seleniumInfra.getTextFromElement(null, null, cells.get(returnColumnText - 1), null);
                }

            }
        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return "";
    }


    public boolean verifyTableCellTextFirstWay(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {

        String actualText = this.getTableCellText(table, searchColumn, searchText, returnColumnText);
        return actualText.equals(expectedText);

    }


    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        try {
            return this.seleniumInfra.getTextFromElement(Locators.XPATH.getLocator(), String.format(HomePageLocators.searchedCell,searchColumn, searchText, returnColumnText), null, table);
        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return "";

    }

    public boolean verifyTableCellTextSecondWay(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {

        String actualText = this.getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
        return actualText.equals(expectedText);
    }

}
