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
@XmlRootElement(name = "getRolesByGroupResponse", namespace = "http://www.webex.com/blis/1.0/dbmethod/admin")
public class GetRolesResponse extends BlisResponse {
    public List<BlisRole> getContent(){
        List<BlisRole> blisRoleList = new ArrayList<BlisRole>();
        if(tuple != null){
            for(Tuple tuple1:tuple){
                Old old = tuple1.getOld();
                BlisRole blisRole = old.getBlisRole();
                if(blisRole == null){
                    continue;
                }
                blisRoleList.add(blisRole);
            }
        }
        return blisRoleList;
    }
}
