package model;

import model.base.Exporter;
import model.base.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.BackingStoreException;

public class Phonebook {
    public Phonebook() {
        this.contacts = new HashMap<>();
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    private int count;
    public boolean addContact(User newContact) {
        if (isSetContact(newContact))
            return false;
        contacts.put(newContact.getPhone().getData(), newContact);
        return true;
    }

    public boolean removeContact(User newContact) {
        if (isSetContact(newContact))
            return false;
        contacts.remove(newContact.getPhone().getData());
        return true;
    }

    public int updateContact(User updContact) {
        if (isSetContact(updContact))
            return -1; // Нет такого контакта
        if (updContact.equals(contacts.get(updContact.getPhone().getData())))
            return 0; // Нечего обновлять
        contacts.put(updContact.getPhone().getData(), updContact);
        return 1; // Обновление прошло успешно
    }

    public User findContact(String phoneNumber){
        if (contacts.containsKey(phoneNumber))
            return contacts.get(phoneNumber);
        return null;
    }

    public void importData(Parser parser){
        for (User user: parser) {
            this.addContact(user);
        }
    }
    public void exportData(Exporter exporter) throws BackingStoreException, IOException, ParserConfigurationException, TransformerException, SAXException {
        exporter.export((User[])contacts.entrySet().toArray());
    }

    private Map<String, User> contacts;

    private boolean isSetContact(User contact) {
        return contacts.containsKey(contact.getPhone().getData());
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (String ks : contacts.keySet()) {
            out.append(contacts.get(ks).toString());
            out.append("\n");
        }
        return out.toString();
    }
}