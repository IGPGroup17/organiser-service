package com.igp.organiserservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.igp.organiserservice.service.OrganiserService;
import com.igp.organiserservice.service.OrganiserServiceImpl;
import com.igp.organiserservice.util.EnvironmentLogger;
import com.igp.organiserservice.util.ResponseEntity;
import com.igp.organiserservice.util.pattern.PatternMatcher;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        EnvironmentLogger.log(event, context);
        return routeRequest(event, context, new OrganiserServiceImpl()).toApiGatewayProxyResponseEvent();
    }

    private ResponseEntity<?> routeRequest(APIGatewayProxyRequestEvent event, Context context, OrganiserService service) {
        return new PatternMatcher<String, ResponseEntity<?>>()
                .defineCase(
                        "/v1/organisers/{id}", service.getOrganiser(event, context),
                        () -> event.getHttpMethod().equals("GET"))

                .defineCase(
                        "/v1/organisers/create", service.createOrganiser(event, context),
                        () -> event.getHttpMethod().equals("POST"))

                .defineCase(
                        "/v1/organisers/delete/{id}", service.deleteOrganiser(event, context),
                        () -> event.getHttpMethod().equals("DELETE"))

                .defineCase(
                        "/v1/organisers/update", service.updateOrganiser(event, context),
                        () -> event.getHttpMethod().equals("POST"))

                .defaultCase(ResponseEntity.notFound())

                .match(event.getResource());
    }
}
