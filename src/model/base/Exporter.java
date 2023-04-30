package model.base;

import model.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.prefs.BackingStoreException;

public abstract class Exporter {
    /**
     * Экспорт данных
     */
    public abstract void export(User[] data) throws IOException, BackingStoreException, ParserConfigurationException, SAXException, TransformerException;
}
