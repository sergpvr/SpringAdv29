package beans.services;

import beans.models.GroupModel;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.OutputStream;

public class ParserService {

    public GroupModel fromXML(InputStream is) throws JAXBException {
        GroupModel group;
        JAXBContext jaxbContext;

        jaxbContext = JAXBContext.newInstance(GroupModel.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        group = (GroupModel) jaxbUnmarshaller.unmarshal(is);

        return group;
    }

    public void toXML(GroupModel group, OutputStream os) throws JAXBException {
        JAXBContext jaxbContext;

        jaxbContext = JAXBContext.newInstance(GroupModel.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.marshal(group, os);
    }
}
