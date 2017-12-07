package beans.services;

import beans.models.*;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ParserServiceTest {

    private ParserService parserService = new ParserService();
    private static final String expected="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<group>\n" +
            "    <events>\n" +
            "        <id>2</id>\n" +
            "        <name>My First Event</name>\n" +
            "        <rate>LOW</rate>\n" +
            "        <basePrice>100.23</basePrice>\n" +
            "        <dateTime>2017-12-12T15:40</dateTime>\n" +
            "        <auditorium>\n" +
            "            <id>0</id>\n" +
            "            <name>Blue hall</name>\n" +
            "            <seatsNumber>0</seatsNumber>\n" +
            "        </auditorium>\n" +
            "    </events>\n" +
            "    <events>\n" +
            "        <id>3</id>\n" +
            "        <name>My Second Event</name>\n" +
            "        <rate>HIGH</rate>\n" +
            "        <basePrice>125.4</basePrice>\n" +
            "        <dateTime>2017-12-14T11:10</dateTime>\n" +
            "        <auditorium>\n" +
            "            <id>0</id>\n" +
            "            <name>Red hall</name>\n" +
            "            <seatsNumber>0</seatsNumber>\n" +
            "        </auditorium>\n" +
            "    </events>\n" +
            "    <users>\n" +
            "        <id>23</id>\n" +
            "        <email>serhiy@doprocess.com</email>\n" +
            "        <name>Serhiy</name>\n" +
            "        <birthday>1974-07-10</birthday>\n" +
            "    </users>\n" +
            "    <users>\n" +
            "        <id>24</id>\n" +
            "        <email>oleksii@doprocess.com</email>\n" +
            "        <name>Oleksii</name>\n" +
            "        <birthday>1982-04-23</birthday>\n" +
            "    </users>\n" +
            "</group>\n";
    private static final GroupModel group;
    static {
        group = new GroupModel();
        group.setUsers(Arrays.asList(
                new User() {{
                    setId(23L);
                    setName("Serhiy");
                    setEmail("serhiy@doprocess.com");
                    setBirthday(LocalDate.of(1974, Month.JULY, 10));
                }},
                new User() {{
                    setId(24L);
                    setName("Oleksii");
                    setEmail("oleksii@doprocess.com");
                    setBirthday(LocalDate.of(1982, Month.APRIL, 23));
                }}
        ));
        group.setEvents(Arrays.asList(
                new Event() {{
                    setId(2);
                    setRate(Rate.LOW);
                    setName("My First Event");
                    setBasePrice(100.23);
                    setDateTime(LocalDateTime.of(2017, Month.DECEMBER, 12, 15, 40));
                    setAuditorium(new Auditorium() {{
                        setName("Blue hall");
                    }});
                }},
                new Event() {{
                    setId(3);
                    setRate(Rate.HIGH);
                    setName("My Second Event");
                    setBasePrice(125.40);
                    setDateTime(LocalDateTime.of(2017, Month.DECEMBER, 14, 11, 10));
                    setAuditorium(new Auditorium() {{
                        setName("Red hall");
                    }});
                }}
        ));
    }

    @Test
    public void testToXML() throws JAXBException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        parserService.toXML(group, baos);
        assertEquals(expected, baos.toString());
    }

    @Test
    public void testFromXML() throws JAXBException {
        InputStream is = new ByteArrayInputStream( expected.getBytes() );
        GroupModel parsedGroup = parserService.fromXML(is);
        assertEquals(2, parsedGroup.getUsers().size());
        assertEquals(2, parsedGroup.getEvents().size());
    }
}
