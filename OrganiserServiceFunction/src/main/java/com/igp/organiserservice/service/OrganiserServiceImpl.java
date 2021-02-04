package com.igp.organiserservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.organiserservice.model.*;
import com.igp.organiserservice.util.ResponseEntity;

public class OrganiserServiceImpl implements OrganiserService {

    @Override
    public ResponseEntity<OrganiserBasic> getBasicOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_BASIC);
    }

    @Override
    public ResponseEntity<OrganiserDetailed> getDetailedOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_DETAILED);
    }

    @Override
    public ResponseEntity<OrganiserEvents> getEventsOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(Examples.EXAMPLE_UNI);
    }

    @Override
    public ResponseEntity<Organiser> updateOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Organiser("Update"));
    }

    @Override
    public ResponseEntity<Organiser> createOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Organiser("Create"));
    }

    @Override
    public ResponseEntity<Organiser> deleteOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Organiser("Delete"));
    }

    @Override
    public ResponseEntity<Organiser> addEvent(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(new Organiser("Added Event"));
    }
}
