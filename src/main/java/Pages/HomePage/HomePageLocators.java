package Pages.HomePage;

import Pages.BasePage;

public class HomePageLocators extends BasePage {

    public static final String table = "//table[@id=\"customers\"]//tbody";
    public static final String rows = ".//tr";
    public static final String cellsInRows = ".//td";
    public static final String searchedCell = ".//tr//td[%d][text()=\"%s\"]/parent::tr//td[%d]";


}
