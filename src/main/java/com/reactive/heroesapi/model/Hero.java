package com.reactive.heroesapi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "heroes")
public class Hero {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;
    private String name;
    private String universe;
    private Long films;
}
