package com.igp.organiserservice.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.igp.organiserservice.config.DynamoDBConfig;
import com.igp.organiserservice.model.Organiser;

import java.util.HashMap;
import java.util.Map;

public class OrganiserServiceDaoImpl implements OrganiserCrudDao {
    private DynamoDBMapper dynamoDBMapper;

    public OrganiserServiceDaoImpl() {
        this.dynamoDBMapper = DynamoDBConfig.dynamoDBMapper();
    }

    @Override
    public Organiser createOrganiser(Organiser user) {
        dynamoDBMapper.save(user);
        return user;
    }

    @Override
    public Organiser readOrganiser(String organiserId) {
        return dynamoDBMapper.load(Organiser.class, organiserId);
    }

    @Override
    public Organiser updateOrganiser(Organiser organiser) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("organiserId", new ExpectedAttributeValue(new AttributeValue().withS(organiser.getOrganiserId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(organiser, saveExpression);
        return organiser;
    }

    @Override
    public void deleteOrganiser(String organiserId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("organiserId", new ExpectedAttributeValue(new AttributeValue().withS(organiserId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        Organiser organiser = Organiser.builder()
                .organiserId(organiserId)
                .build();
        dynamoDBMapper.delete(organiser, deleteExpression);
    }
}
