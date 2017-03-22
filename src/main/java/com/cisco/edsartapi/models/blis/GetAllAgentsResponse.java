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
@XmlRootElement(name = "getAllAgentsResponse", namespace = "http://www.webex.com/blis/1.0/dbmethod/admin")
public class GetAllAgentsResponse extends BlisResponse {//Report to
    public List<BlisAgent> getContent(){
        List<BlisAgent> blisAgentList = new ArrayList<BlisAgent>();
        if(tuple != null){
            for(Tuple tuple1:tuple){
                Old old = tuple1.getOld();
                BlisAgent blisAgent = old.getBlisAgent();
                if(blisAgent == null){
                    continue;
                }
                blisAgentList.add(blisAgent);
            }
        }
        return blisAgentList;
    }
}
