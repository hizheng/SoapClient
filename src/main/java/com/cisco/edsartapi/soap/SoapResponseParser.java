package com.cisco.edsartapi.soap;

import com.cisco.edsartapi.models.blis.GetGroupsResponse;
import com.cisco.edsartapi.models.blis.AuthenticateResponse;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by zhenghu on 3/17/17.
 */
public class SoapResponseParser {

    public static void main(String[] args) throws Exception {
        String sessionId = parseAuthenticateResponse();
        GetGroupsResponse getGroupsResponse = parseApiResponse(sessionId);
        System.out.println("End");
    }

    public static GetGroupsResponse parseApiResponse(String wcpsession) throws Exception {
        SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = cf.createConnection();
        String url = "http://10.224.167.18/com.eibus.web.soap.Gateway.wcp";
        url = url + "?wcp-session=" + wcpsession;
        URL endpoint = new URL(url);
        InputStream inputStream = SoapResponseParser.class.getClassLoader().getResourceAsStream("getGroups_request.xml");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b, 0, b.length)) != -1) {
            baos.write(b, 0, len);
        }
        byte[] buffer =  baos.toByteArray();
        String request = new String(buffer, StandardCharsets.UTF_8);
        MessageFactory messageFactory = MessageFactory.newInstance();
        MimeHeaders header = new MimeHeaders();
        SOAPMessage soapMessage = messageFactory.createMessage(header,
                new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8)));
//                inputStream);
        SOAPMessage resp = connection.call(soapMessage, endpoint);
        resp.writeTo(System.out);

        //get the soap body content
        SOAPBody soapBody = resp.getSOAPBody();
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
        System.out.println(sw.toString());

        JAXBContext jc = JAXBContext.newInstance(GetGroupsResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        InputStream inputStream1 = new ByteArrayInputStream(xml.getBytes());
        GetGroupsResponse response = (GetGroupsResponse)unmarshaller.unmarshal(inputStream1);
        return response;
    }

    public static GetGroupsResponse parseApiResponse2() throws XMLStreamException, JAXBException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = SoapResponseParser.class.getClassLoader().getResourceAsStream("getGroups_response.xml");
        XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inputStream);
        while(xsr.hasNext()){
            int eventType = xsr.next();
            if(eventType == XMLStreamConstants.START_ELEMENT &&
                    xsr.getLocalName().equals("getGroupsResponse")) {
                break;
            }
        }
        System.out.println(xsr.getName());
        JAXBContext jc = JAXBContext.newInstance(GetGroupsResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<GetGroupsResponse> je = unmarshaller.unmarshal(xsr, GetGroupsResponse.class);
        System.out.println(je.getName());
        GetGroupsResponse getGroupsResponse = je.getValue();
        return getGroupsResponse;
    }

    public static String parseAuthenticateResponse() throws Exception {
        SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = cf.createConnection();
        String url = "http://10.224.167.18/com.eibus.web.soap.Authenticate.wcp";
        URL endpoint = new URL(url);
        InputStream inputStream = SoapResponseParser.class.getClassLoader().getResourceAsStream("authenticate_request.xml");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b, 0, b.length)) != -1) {
            baos.write(b, 0, len);
        }
        byte[] buffer =  baos.toByteArray();
        String request = new String(buffer, StandardCharsets.UTF_8);
        request = request.replaceAll("@USERNAME@", "boss");
        request = request.replaceAll("@PASSWORD@", "1BLiS2006");
        MessageFactory messageFactory = MessageFactory.newInstance();
        MimeHeaders header = new MimeHeaders();
        SOAPMessage soapMessage = messageFactory.createMessage(header,
                new ByteArrayInputStream(request.getBytes(StandardCharsets.UTF_8)));
//                inputStream);
        SOAPMessage resp = connection.call(soapMessage, endpoint);
        resp.writeTo(System.out);

        //get the soap body content
        SOAPBody soapBody = resp.getSOAPBody();
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
        System.out.println(sw.toString());

        JAXBContext jc = JAXBContext.newInstance(AuthenticateResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        InputStream inputStream1 = new ByteArrayInputStream(xml.getBytes());
        AuthenticateResponse response = (AuthenticateResponse)unmarshaller.unmarshal(inputStream1);
        String wcpsession = response.getWcpsession();
        return wcpsession;
    }

    public static String parseAuthenticateResponse2() throws XMLStreamException, JAXBException {
        String sessionId = "";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = SoapResponseParser.class.getClassLoader().getResourceAsStream("authenticate_response.xml");
        XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inputStream);
        while(xsr.hasNext()){
            int eventType = xsr.next();
            if(eventType == XMLStreamConstants.START_ELEMENT &&
                    xsr.getLocalName().equals("wcp-session")) {
                if(xsr.next() == XMLStreamConstants.CHARACTERS){
                    sessionId = xsr.getText();
                    break;
                }
            }
        }
        return sessionId;
    }
}
