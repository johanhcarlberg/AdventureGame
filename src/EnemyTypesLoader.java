import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class EnemyTypesLoader extends XMLLoader {
    private Map<String,ArrayList<EnemyTypes>> enemyTypes;
    public EnemyTypesLoader(File file) {
        super(file);
        enemyTypes = new HashMap<>();
    }

    public List<EnemyTypes> getEnemyTypesByWorld(String world) {
        return enemyTypes.get(world);
    }

    public void load() {
        try {
            FileInputStream fileIS = new FileInputStream(getFile());
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/enemyTypes/enemyType";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element enemyType = (Element) nodeList.item(i);
                String world = enemyType.getAttribute("world");
                try {
                String name = xPath.evaluate("./name/text()", enemyType);
                if (name == null || name.isEmpty()) {
                    throw new XPathExpressionException("Invalid enemy type name");
                }
                int maxHealth = Integer.parseInt(xPath.evaluate("./maxHealth", enemyType));
                int strength = Integer.parseInt(xPath.evaluate("./strength", enemyType));
                int dexterity = Integer.parseInt(xPath.evaluate("./dexterity", enemyType));
                int experience = Integer.parseInt(xPath.evaluate("./dexterity", enemyType));

                EnemyTypes et = new EnemyTypes(name, maxHealth, strength, dexterity, experience);
                
                ArrayList<EnemyTypes> etList = enemyTypes.get(world);
                if (etList == null) {
                    etList = new ArrayList<EnemyTypes>();
                    enemyTypes.put(world, etList);
                }
                etList.add(et);
                } catch(NumberFormatException e) {
                    System.out.println("Couldn't add enemyType, invalid integer.");
                    continue;
                } catch(XPathExpressionException e) {
                    System.out.println("Invalid xPath expression when adding enemyType: " + e.getMessage());
                    continue;
                } catch(Exception e) {
                    System.out.println("Couldn't add enemyType: " + e.getMessage());
                    continue;
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("File " + getFile().getAbsolutePath() + " not found.");
        } catch(ParserConfigurationException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(SAXException e) {
            e.printStackTrace();
        } catch(XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
