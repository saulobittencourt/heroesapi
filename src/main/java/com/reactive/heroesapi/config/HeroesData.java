package com.reactive.heroesapi.config;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.reactive.heroesapi.utils.AWSConnect;

public class HeroesData {

    public static void main(String [] args) throws Exception{
        DynamoDB dynamoDB = AWSConnect.connectAws();

        Table table = dynamoDB.getTable("heroes");

        Item hero = new Item()
                .withPrimaryKey("id","1")
                .withString("name","Iron Man")
                .withString("universe","Marvel")
                .withNumber("films",5);

        PutItemOutcome outcome = table.putItem(hero);
    }
}
