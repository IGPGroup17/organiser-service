package com.igp.organiserservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.organiserservice.model.OrganiserBasic;
import com.igp.organiserservice.model.Organiser;
import com.igp.organiserservice.model.OrganiserDetailed;
import com.igp.organiserservice.model.OrganiserEvents;
import com.igp.organiserservice.util.IService;
import com.igp.organiserservice.util.ResponseEntity;

public interface OrganiserService extends IService {

    ResponseEntity<OrganiserBasic> getBasicOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<OrganiserDetailed> getDetailedOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<OrganiserEvents> getEventsOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Organiser> updateOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Organiser> createOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Organiser> deleteOrganiser(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Organiser> addEvent(APIGatewayProxyRequestEvent event, Context context);
}
