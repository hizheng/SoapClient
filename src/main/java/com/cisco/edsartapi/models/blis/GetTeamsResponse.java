package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghu on 3/17/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getSalesTeamInfoResponse", namespace = "http://www.webex.com/blis/1.0/dbmethod/admin")
public class GetTeamsResponse extends BlisResponse {
    public List<BlisTeam> getContent(){
        List<BlisTeam> blisTeamList = new ArrayList<BlisTeam>();
        if(tuple != null){
            for(Tuple tuple1:tuple){
                Old old = tuple1.getOld();
                BlisTeam blisTeam = old.getBlisTeam();
                if(blisTeam == null){
                    continue;
                }
                blisTeamList.add(blisTeam);
            }
        }
        return blisTeamList;
    }
}
