package com.cisco.edsartapi.models.blis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by zhenghu on 3/21/17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BlisResponse {
    @XmlElement(name = "tuple")
    protected List<Tuple> tuple;

    public List<Tuple> getTuple() {
        return tuple;
    }

    public void setTuple(List<Tuple> tuple) {
        this.tuple = tuple;
    }

    public abstract List getContent();
}
