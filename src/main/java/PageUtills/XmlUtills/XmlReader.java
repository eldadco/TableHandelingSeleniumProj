package PageUtills.XmlUtills;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XmlReader {
    List<HashMap> inputs = new ArrayList<>();

    public List<HashMap> getInputsFromXml() {

        try {

            File fXmlFile = new File("src\\main\\resources\\Inputs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList tests = doc.getElementsByTagName("test");


            System.out.println("----------------------------");

            for (int i = 0; i < tests.getLength(); i++) {
                Node node = tests.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;
                    HashMap<String, String> temp = new HashMap<>();
                    temp.put("searchColumn", eElement.getElementsByTagName("searchColumn").item(0).getTextContent());
                    temp.put("searchText", eElement.getElementsByTagName("searchText").item(0).getTextContent());
                    temp.put("returnColumnText", eElement.getElementsByTagName("returnColumnText").item(0).getTextContent());
                    temp.put("expectedText", eElement.getElementsByTagName("expectedText").item(0).getTextContent());
                    temp.put("testType",eElement.getElementsByTagName("testType").item(0).getTextContent());
                    this.inputs.add(temp);

                }
            }
            return this.inputs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}