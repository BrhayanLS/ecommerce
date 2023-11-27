package com.ecommerce;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class PruebaConexionMongoDB {
    private final String connectionString;
    private final String databaseName;
    private MongoClient mongoClient;
    private MongoDatabase database;

    public PruebaConexionMongoDB(String connectionString, String databaseName) {
        this.connectionString = connectionString;
        this.databaseName = databaseName;
    }

    public void connect() {
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(databaseName);
        System.out.println("conexión exitosa");
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

}

