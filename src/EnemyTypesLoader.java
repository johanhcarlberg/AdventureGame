import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EnemyTypesLoader implements XMLLoader<EnemyTypes> {
    private File file;
    public EnemyTypesLoader(File file) {
        this.file = file;
    }
    public List<EnemyTypes> load() {
        try {
            FileInputStream fileIS = new FileInputStream(file);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/enemyTypes/enemyType";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element enemyType = (Element) nodeList.item(i);
                String name = xPath.evaluate("./name/text()", enemyType);
                double maxHealth = (double) xPath.evaluate("./maxHealth", enemyType, XPathConstants.NUMBER);
                double strength = (double) xPath.evaluate("./strength", enemyType, XPathConstants.NUMBER);
                double dexterity = (double) xPath.evaluate("./dexterity", enemyType, XPathConstants.NUMBER);
                double experience = (double) xPath.evaluate("./dexterity", enemyType, XPathConstants.NUMBER);
                System.out.println(name);
                System.out.println(maxHealth);
                System.out.println(strength);
                System.out.println(dexterity);
                System.out.println(experience);

            }
            
        } catch(FileNotFoundException e) {
            System.out.println("File " + file.getAbsolutePath() + " not found.");
        } catch(ParserConfigurationException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(SAXException e) {
            e.printStackTrace();
        } catch(XPathExpressionException e) {
            e.printStackTrace();
        }


        return new ArrayList<EnemyTypes>();
    }
}
