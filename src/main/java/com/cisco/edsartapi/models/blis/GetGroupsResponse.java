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
@XmlRootElement(name = "getGroupsResponse", namespace = "http://www.webex.com/blis/1.0/dbmethod/admin")
public class GetGroupsResponse extends BlisResponse {
    public List getContent(){
        List blisGroupList = new ArrayList<BlisGroup>();
        if(tuple != null){
            for(Tuple tuple1:tuple){
                Old old = tuple1.getOld();
                BlisGroup blisGroup = old.getBlisGroup();
                if(blisGroup == null){
                    continue;
                }
                blisGroupList.add(blisGroup);
            }
        }
        return blisGroupList;
    }
}

