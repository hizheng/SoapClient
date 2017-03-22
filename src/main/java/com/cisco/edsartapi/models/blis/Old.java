package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhenghu on 3/17/17.
 */

@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(name = "old")
public class Old {
    @XmlElement(name = "BLIS_GROUP", nillable = true)
    private BlisGroup blisGroup;

    @XmlElement(name = "BLIS_TEAM", nillable = true)
    private BlisTeam blisTeam;

    @XmlElement(name = "BLIS_ROLEASSIGNMENT", nillable = true)
    private BlisRole blisRole;

    @XmlElement(name = "BLIS_AGENT", nillable = true)
    private BlisAgent blisAgent;

    @XmlElement(name = "blis_agent", nillable = true)
    private BlisAgent blisCMAgent;

    public BlisGroup getBlisGroup() {
        return blisGroup;
    }

    public void setBlisGroup(BlisGroup blisGroup) {
        this.blisGroup = blisGroup;
    }

    public BlisTeam getBlisTeam() {
        return blisTeam;
    }

    public void setBlisTeam(BlisTeam blisTeam) {
        this.blisTeam = blisTeam;
    }

    public BlisRole getBlisRole() {
        return blisRole;
    }

    public void setBlisRole(BlisRole blisRole) {
        this.blisRole = blisRole;
    }

    public BlisAgent getBlisAgent() {
        return blisAgent;
    }

    public void setBlisAgent(BlisAgent blisAgent) {
        this.blisAgent = blisAgent;
    }

    public BlisAgent getBlisCMAgent() {
        return blisCMAgent;
    }

    public void setBlisCMAgent(BlisAgent blisCMAgent) {
        this.blisCMAgent = blisCMAgent;
    }
}
