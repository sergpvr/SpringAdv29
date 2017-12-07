package beans.services;

import beans.models.GroupModel;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.OutputStream;

public class ParserService {
    private static Logger log = Logger.getLogger(ParserService.class.getName());

    GroupModel fromXML(InputStream is) throws JAXBException {
        GroupModel group;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(GroupModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            group = (GroupModel) jaxbUnmarshaller.unmarshal(is);
        } catch (JAXBException ex) {
            log.error("Error parsing xml", ex);
            throw ex;
        }
        return group;
    }

    void toXML(OutputStream os, GroupModel group) {

    }
}
