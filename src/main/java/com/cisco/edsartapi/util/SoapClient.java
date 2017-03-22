package com.cisco.edsartapi.util;

import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by zhenghu on 3/21/17.
 */
public class SoapClient {
    public static SOAPMessage buildSOAPRequest(String request) throws SOAPException, IOException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        MimeHeaders header = new MimeHeaders();
        SOAPMessage soapMessage = messageFactory.createMessage(header,
                new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8)));
        return soapMessage;
    }

    public static SOAPMessage sendMessage(String url, SOAPMessage request) throws MalformedURLException, SOAPException {
        SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = cf.createConnection();
        URL endpoint = new URL(url);
        SOAPMessage resp = connection.call(request, endpoint);
        return resp;
    }

    public static <T> T parseSOAPResponse(SOAPMessage response, Class<T> clazz) throws SOAPException, TransformerException, JAXBException {
        SOAPBody soapBody = response.getSOAPBody();
        Document document = soapBody.extractContentAsDocument();

        //transform document to xml string
        StringWriter sw = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, StandardCharsets.UTF_8.toString());
        transformer.transform(new DOMSource(document), new StreamResult(sw));
        String xml = sw.toString();

        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        T result = (T)unmarshaller.unmarshal(inputStream);
        return result;
    }
}
