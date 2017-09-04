package textadventure;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class SzeneFactory {
    public static Szene geyByID(int id) {
        Node n = getXML(id);
        return getSzene(n);
    }

    private static Node getXML(int id) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            InputStream is = SzeneFactory.class.getResourceAsStream("Szenen.xml");
            Document doc = dbBuilder.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("Szene");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);
                String wert = getTagValue("id", e);
                if (Integer.valueOf(wert) == id) return nodeList.item(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("Falsche ID!");
        return null;
    }

    private static Szene getSzene(Node node) {
        Szene szene = new Szene();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            szene.setText(getTagValue("Text", element));
            szene.setOptions(getTagValues("Option", element));
        }

        return szene;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static ArrayList<String> getTagValues(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        ArrayList<String> werte = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            werte.add(nodeList.item(i).getChildNodes().item(0).getNodeValue());
        }
        return werte;
    }
}
