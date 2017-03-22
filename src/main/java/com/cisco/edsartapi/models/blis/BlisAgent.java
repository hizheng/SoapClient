package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhenghu on 3/21/17.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class BlisAgent {
    @XmlElement(name = "AGENTID")
    private String agentId;
    @XmlElement(name = "USERID", nillable = true)
    private String userId;
    @XmlElement(name = "AGENTNAME")
    private String agentName;
    @XmlElement(name = "GROUPID", nillable = true)
    private String groupId;
    @XmlElement(name = "GROUPNAME", nillable = true)
    private String groupName;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
