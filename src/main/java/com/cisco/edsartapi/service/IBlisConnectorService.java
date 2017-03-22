package com.cisco.edsartapi.service;

import com.cisco.edsartapi.models.blis.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhenghu on 3/21/17.
 */
public interface IBlisConnectorService {
    <T extends BlisResponse> List getBlisApiResult(Class<T> clazz,  String requestTemplateFile, Map placeHolders);
    void createUser(String requestTemplateFile, Map placeHolders);
}
