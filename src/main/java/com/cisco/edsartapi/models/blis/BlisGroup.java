package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhenghu on 3/17/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BlisGroup {
    @XmlElement(name = "GROUPID")
    private String groupId;
    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "PARENTGROUPID")
    private String parentGroupId;
    @XmlElement(name = "PARENTGROUPNAME")
    private String getParentGroupName;
    @XmlElement(name = "CREATEDBY")
    private String createdBy;
    @XmlElement(name = "CREATIONDATE")
    private String creationDate;
    @XmlElement(name = "LASTMODIFIEDBY")
    private String lastModifiedBy;
    @XmlElement(name = "LASTMODIFIEDDATE")
    private String lastModifiedDate;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public String getGetParentGroupName() {
        return getParentGroupName;
    }

    public void setGetParentGroupName(String getParentGroupName) {
        this.getParentGroupName = getParentGroupName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
