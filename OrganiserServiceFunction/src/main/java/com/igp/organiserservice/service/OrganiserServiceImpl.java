package com.igp.organiserservice.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.organiserservice.dao.OrganiserCrudDao;
import com.igp.organiserservice.dao.OrganiserServiceDaoImpl;
import com.igp.organiserservice.model.*;
import com.igp.organiserservice.util.RequestBodyReader;
import com.igp.organiserservice.util.ResponseEntity;
import com.igp.organiserservice.util.path.PathParameters;

public class OrganiserServiceImpl implements OrganiserService {

    private OrganiserCrudDao organiserCrudDao;

    public OrganiserServiceImpl() {
        this.organiserCrudDao = new OrganiserServiceDaoImpl();
    }

    @Override
    public ResponseEntity<Organiser> createOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        Organiser organiser = RequestBodyReader.getAsObject(event.getBody(),Organiser.class);
        return ResponseEntity.ok(organiserCrudDao.createOrganiser(organiser));
    }

    @Override
    public ResponseEntity<Organiser> getOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(organiserCrudDao.readOrganiser(PathParameters.getPathParameter(event,"id")));
    }

    @Override
    public ResponseEntity<Organiser> updateOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        Organiser organiser = RequestBodyReader.getAsObject(event.getBody(),Organiser.class);
        return ResponseEntity.ok(organiserCrudDao.updateOrganiser(organiser));
    }

    @Override
    public ResponseEntity<Organiser> deleteOrganiser(APIGatewayProxyRequestEvent event, Context context) {
        organiserCrudDao.deleteOrganiser((PathParameters.getPathParameter(event,"id")));
        return null;
    }
}
