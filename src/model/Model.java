package model;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

public class Model {

    public boolean addContact(User contact){
        return  pb.addContact(contact);
    }

    public boolean removeContact(String phonenumber){
        return  pb.removeContact(phonenumber);
    }
    public int updateContact(String phonenumber, User contact){
        return  pb.updateContact(phonenumber, contact);
    }
    public User findContact(String phoneNumber){
        return  pb.findContact(phoneNumber);
    }
    public void exportCSV(String filename) throws BackingStoreException, IOException, ParserConfigurationException, TransformerException, SAXException {
        pb.exportData(new CsvExporter(filename));
    }
    public void exportXML(String filename) throws BackingStoreException, IOException, ParserConfigurationException, TransformerException, SAXException {
        pb.exportData(new XMLExporter(filename));
    }

    public void importCSV(String filename) throws FileNotFoundException {
        pb.importData(new CsvParse(filename));
    }
    public void importXML(String filename) throws FileNotFoundException {
        pb.importData(new XMLParse(filename));
    }

    private Phonebook pb = new Phonebook();

    @Override
    public String toString() {
        return pb.toString();
    }
}
