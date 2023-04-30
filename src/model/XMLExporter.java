package model;

import model.base.Exporter;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;



public class XMLExporter extends Exporter {
    public XMLExporter(String filename) {
        this.filename = filename;
    }

    private String filename;

    @Override
    public void export(User[] data) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element rootEle = document.createElement("users");
        document.appendChild(rootEle);

        for (User user : data) {
            Element usr = document.createElement("user");
            rootEle.appendChild(usr);

            Attr attr = document.createAttribute("phone");
            attr.setValue(user.getPhone().getData());
            usr.setAttributeNode(attr);

            Element fn = document.createElement("FirstName");
            fn.appendChild(document.createTextNode(user.getFirstName().getData()));
            usr.appendChild(fn);

            Element ln = document.createElement("LastName");
            ln.appendChild(document.createTextNode(user.getLastName().getData()));
            usr.appendChild(ln);

            Element comment = document.createElement("Comment");
            comment.appendChild(document.createTextNode(user.getDescription()));
            usr.appendChild(comment);

            Element cd = document.createElement("CustomData");
            usr.appendChild(cd);

            for (String ks : user.getCustomData().keySet()) {

                Element cl = document.createElement(user.getCustomData().get(ks).getClass().getSimpleName());
                cl.appendChild(document.createTextNode(user.getCustomData().get(ks).getData().toString()));
                cd.appendChild(cl);

                Attr clAttr = document.createAttribute("name");
                clAttr.setValue(user.getCustomData().get(ks).getDataName());
                cl.setAttributeNode(clAttr);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
        }
    }
}
