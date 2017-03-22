package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.*;

/**
 * Created by zhenghu on 3/20/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuthenticateResponse", namespace = "http://schemas.cordys.com/1.0/webgateway")
//@XmlType(name = "AuthenticateResponse")
public class AuthenticateResponse{
    @XmlElement(name = "wcp-session")
    private String wcpsession;

    public String getWcpsession() {
        return wcpsession;
    }

    public void setWcpsession(String wcpsession) {
        this.wcpsession = wcpsession;
    }
}
