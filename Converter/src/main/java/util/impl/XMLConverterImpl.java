package util.impl;

import util.XMLConverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLConverterImpl implements XMLConverter {
    @Override
    public String toXML(Object object) {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, sw);
            return sw.toString();
        }
        catch (JAXBException ignored) { }
        return null;
    }

    @Override
    public Object toObject(String string, Class<?> objectClass) {
        try {
            StringReader reader = new StringReader(string);
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(reader);
        }
        catch (JAXBException ignored) { }
        return null;
    }

    @Override
    public Object toObject(File file, Class<?> objectClass) {
        try {
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        }
        catch (JAXBException ignored) { }
        return null;
    }
}
