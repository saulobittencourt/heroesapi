package com.reactive.heroesapi.utils;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import static com.reactive.heroesapi.constants.HeroesConstants.DYNAMO_ENDPOINT;
import static com.reactive.heroesapi.constants.HeroesConstants.REGION_DYNAMO;

public class AWSConnect {

    public static DynamoDB connectAws(){
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        return dynamoDB;
    }
}
