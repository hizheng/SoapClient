package com.cisco.edsartapi.controller;

import com.cisco.edsartapi.models.blis.*;
import com.cisco.edsartapi.service.IBlisConnectorService;
import com.cisco.edsartapi.service.impl.BlisConnectorServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenghu on 3/21/17.
 */
public class BlisConnectorController {

    private IBlisConnectorService blisConnectorService;

    public void setBlisConnectorService(IBlisConnectorService blisConnectorService){
        this.blisConnectorService = blisConnectorService;
    }

    public List<BlisGroup> getGroups(){
        List<BlisGroup> blisGroupList = blisConnectorService.getBlisApiResult(GetGroupsResponse.class, "/getGroups_request.xml", null);
        return blisGroupList;
    }

    public List<BlisRole> getRoles(){
        List<BlisRole> blisRoleList = blisConnectorService.getBlisApiResult(GetRolesResponse.class, "/getRoles_request.xml", null);
        return blisRoleList;
    }

    public List<BlisTeam> getTeamsByGroupName(String groupName){
        Map placeHolders = new HashMap();
        placeHolders.put("@GROUPNAME@", groupName);
        List<BlisTeam> blisTeamList = blisConnectorService.getBlisApiResult(GetTeamsResponse.class, "/getTeamsByGroupName_request.xml", placeHolders);
        return blisTeamList;
    }

    public List<BlisAgent> getReportTos(){
        List<BlisAgent> blisAgentList = blisConnectorService.getBlisApiResult(GetAllAgentsResponse.class, "/getReportTos_request.xml", null);
        return blisAgentList;
    }

    public List<BlisAgent> getCSPMappings(){
        List<BlisAgent> blisAgentList = blisConnectorService.getBlisApiResult(GetCMAgentsResponse.class, "/getCSPMappings_request.xml", null);
        return blisAgentList;
    }

    public void createUser(){
        Map placeHolders = new HashMap();
        placeHolders.put("@USERID@", "testss");
        blisConnectorService.createUser("/createUser_request.xml", placeHolders);
    }


    public static void main(String[] args) {
        BlisConnectorController controller = new BlisConnectorController();
        controller.setBlisConnectorService(new BlisConnectorServiceImpl());
        List<BlisGroup> blisGroupList = controller.getGroups();
        List<BlisRole> blisRoleList = controller.getRoles();
        List<BlisTeam> blisTeamList = controller.getTeamsByGroupName("Sales");
        List<BlisAgent> blisReportTos = controller.getReportTos();
        List<BlisAgent> blisCSPMappings = controller.getCSPMappings();
        System.out.println("END");
    }
}
