package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhenghu on 3/21/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BlisRole {
    @XmlElement(name = "ROLEASSIGNMENTID")
    private String roleAssignmentId;
    @XmlElement(name = "ASSIGNEEID")
    private String assigneeId;
    @XmlElement(name = "ROLEID")
    private String roleId;
    @XmlElement(name = "CREATEDBY")
    private String createdBy;
    @XmlElement(name = "CREATIONDATE")
    private String creationDate;
    @XmlElement(name = "LASTMODIFIEDBY")
    private String lastModifiedBy;
    @XmlElement(name = "LASTMODIFIEDDATE")
    private String lastModifiedDate;
    @XmlElement(name = "ROLENAME")
    private String roleName;
    @XmlElement(name = "GROUPNAME")
    private String groupName;
    @XmlElement(name = "GROUPID")
    private String groupId;

    public String getRoleAssignmentId() {
        return roleAssignmentId;
    }

    public void setRoleAssignmentId(String roleAssignmentId) {
        this.roleAssignmentId = roleAssignmentId;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
