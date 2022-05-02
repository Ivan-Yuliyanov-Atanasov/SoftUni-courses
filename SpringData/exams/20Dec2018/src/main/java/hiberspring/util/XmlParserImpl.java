package hiberspring.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {

    private JAXBContext jaxbContext;


    @SuppressWarnings("unchecked")
    @Override
    public <O> O parseXml(Class<O> objectClass, String filePath) throws JAXBException, FileNotFoundException {
        jaxbContext = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (O) unmarshaller.unmarshal(new FileReader(filePath));
    }
}
