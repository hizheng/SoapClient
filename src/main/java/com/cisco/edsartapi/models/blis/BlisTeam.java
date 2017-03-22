package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhenghu on 3/20/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BlisTeam {
    @XmlElement(name = "TEAMID")
    private String teamId;
    @XmlElement(name = "TEAMCODE")
    private String teamCode;
    @XmlElement(name = "NAME")
    private String name;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
