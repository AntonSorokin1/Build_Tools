package tasks;

import entity.Shop;
import util.JSONConverter;
import util.XMLConverter;
import util.impl.JSONConverterImpl;
import util.impl.XMLConverterImpl;

import java.io.File;

public class Task {
    public void start() {
        // XML-/JSON-file
        File xmlFile = new File("src/main/resources/xml/SomeShop.xml");
        File jsonFile = new File("src/main/resources/json/SomeShop.json");

        // XML-Object-JSON Converter
        // Converters
        XMLConverter xmlConverter = new XMLConverterImpl();
        JSONConverter jsonConverter = new JSONConverterImpl();

        // XML to Object
        Shop xmlShop = (Shop) xmlConverter.toObject(xmlFile, Shop.class);
        System.out.println(xmlShop.toString());
        // Object to XML
        String xmlString = xmlConverter.toXML(xmlShop);
        System.out.println(xmlString);

        // JSON to Object
        Shop jsonShop = (Shop) jsonConverter.toObject(jsonFile, Shop.class);
        System.out.println(jsonShop.toString());
        // Object to JSON
        String jsonString = jsonConverter.toJSON(jsonShop);
        System.out.println(jsonString);

        // JSON to XML
        String convertedXMLString = xmlConverter.toXML(jsonConverter.toObject(jsonFile, Shop.class));
        System.out.println(convertedXMLString);
        // XML to JSON
        String convertedJSONString = jsonConverter.toJSON(xmlConverter.toObject(xmlFile, Shop.class));
        System.out.println(convertedJSONString);
    }
}
