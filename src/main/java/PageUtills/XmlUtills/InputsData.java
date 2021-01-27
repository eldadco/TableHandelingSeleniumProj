package PageUtills.XmlUtills;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.List;

public class InputsData {
    List<HashMap> data ;
    public InputsData()
    {
        XmlReader xmlReader = new XmlReader();
        data = xmlReader.getInputsFromXml();

    }
    public HashMap getDataByTestId(int index)
    {
        return data.get(index - 1);
    }

    public int getNumOfTests()
    {
        return data.size();
    }
}
