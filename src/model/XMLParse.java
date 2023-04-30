package model;

import model.base.CustomData;
import model.base.Parser;
import model.custom_data.Email;
import model.custom_data.Name;
import model.custom_data.PhoneNumber;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XMLParse extends Parser {
    public XMLParse(String filename) throws FileNotFoundException {
        super(parce(filename));
    }

    private static ArrayList<User> parce(String filename) throws FileNotFoundException {
        ArrayList<User> res = new ArrayList<>();

        try {
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");


            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    res.add(new User(eElement.getElementsByTagName("FirstName").item(0).getTextContent()
                            , eElement.getElementsByTagName("LastName").item(0).getTextContent()
                            , eElement.getAttribute("phone")
                            , eElement.getElementsByTagName("LastName").item(0).getTextContent()
                            , parceCS(eElement.getElementsByTagName("CustomData").item(0).getChildNodes())));

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    private static CustomData[] parceCS(NodeList cs) throws Exception {
        CustomData[] res = new CustomData[cs.getLength()];

        for (int i = 0; i < cs.getLength(); i++) {
            Node nNode = cs.item(i);
            Element eElement = (Element) nNode;
            String className = eElement.getTagName();

            switch (className) {
                case "Email":
                    res[i] = new Email(eElement.getAttribute("name"), eElement.getTextContent());
                    break;
                case "Name":
                    res[i] = new Name(eElement.getAttribute("name"), eElement.getTextContent());
                    break;
                case "PhoneNumber":
                    res[i] = new PhoneNumber(eElement.getAttribute("name"), eElement.getTextContent());
                    break;
            }

        }
        return res;
    }
}