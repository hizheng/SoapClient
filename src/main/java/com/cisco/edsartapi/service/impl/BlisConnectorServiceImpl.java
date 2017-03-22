package com.cisco.edsartapi.service.impl;

import com.cisco.edsartapi.models.blis.*;
import com.cisco.edsartapi.service.IBlisConnectorService;
import com.cisco.edsartapi.util.SoapClient;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by zhenghu on 3/21/17.
 */
public class BlisConnectorServiceImpl implements IBlisConnectorService{
    /*
     * T is the result class like BlisGroup, BlisRole, ...
     * T1 is the response class like GetGroupsResponse, GetRolesResponse, ...
     */
    public <T extends BlisResponse> List getBlisApiResult(Class<T> clazz,  String requestTemplateFile, Map placeHolders){
        AuthenticateResponse authenticateResponse = authenticate();
        if(authenticateResponse == null){
            return null;
        }
        String wcpsession = authenticateResponse.getWcpsession();
        String url = "http://10.224.167.18/com.eibus.web.soap.Gateway.wcp";
        url = url + "?wcp-session=" + wcpsession;
        List result = new ArrayList();
        try {
            String request = readXmlRequestTemplate(requestTemplateFile, placeHolders);
            SOAPMessage soapRequest = SoapClient.buildSOAPRequest(request);
            SOAPMessage soapResponse = SoapClient.sendMessage(url, soapRequest);
            T apiResponse
                    = SoapClient.parseSOAPResponse(soapResponse, clazz);
            result = apiResponse.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createUser(String requestTemplateFile, Map placeHolders){
        AuthenticateResponse authenticateResponse = authenticate();
        if(authenticateResponse == null){
            return;
        }
        String wcpsession = authenticateResponse.getWcpsession();
        String url = "http://10.224.167.18/com.eibus.web.soap.Gateway.wcp";
        url = url + "?wcp-session=" + wcpsession;
        try{
            String request = readXmlRequestTemplate(requestTemplateFile, placeHolders);
            SOAPMessage soapRequest = SoapClient.buildSOAPRequest(request);
            SOAPMessage soapResponse = SoapClient.sendMessage(url, soapRequest);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    private AuthenticateResponse authenticate() {
        String url = "http://10.224.167.18/com.eibus.web.soap.Authenticate.wcp";
        String userName = "boss";
        String password = "1BLiS2006";
        AuthenticateResponse authenticateResponse = null;
        try{
            Map placeHolders = new HashMap();
            placeHolders.put("@USERNAME@", userName);
            placeHolders.put("@PASSWORD@", password);
            String request = readXmlRequestTemplate("/authenticate_request.xml", placeHolders);
            SOAPMessage soapRequest = SoapClient.buildSOAPRequest(request);
            SOAPMessage soapResponse = SoapClient.sendMessage(url, soapRequest);
            authenticateResponse
                    = SoapClient.parseSOAPResponse(soapResponse, AuthenticateResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return authenticateResponse;
    }

    private String readXmlRequestTemplate(String templateFile, Map placeHolders) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(templateFile);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b, 0, b.length)) != -1) {
            baos.write(b, 0, len);
        }
        byte[] buffer =  baos.toByteArray();
        String request = new String(buffer, StandardCharsets.UTF_8);
        if(placeHolders != null){
            Iterator iterator = placeHolders.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                request = request.replaceAll(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return request;
    }

    public static void main(String[] args) {
        IBlisConnectorService iBlisConnectorService = new BlisConnectorServiceImpl();
        iBlisConnectorService.getBlisApiResult(GetGroupsResponse.class, "/getGroups_request.xml", null);
    }
}
