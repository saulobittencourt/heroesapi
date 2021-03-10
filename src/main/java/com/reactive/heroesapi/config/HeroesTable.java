package com.reactive.heroesapi.config;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.reactive.heroesapi.utils.AWSConnect;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {

    public static void main(String [] args){
        DynamoDB dynamoDB = AWSConnect.connectAws();

        String tableName = "heroes";

        try {
            Table table = dynamoDB.createTable(
                        tableName,
                        Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                        Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                        new ProvisionedThroughput(5L,5L)
                    );
            table.waitForActive();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
