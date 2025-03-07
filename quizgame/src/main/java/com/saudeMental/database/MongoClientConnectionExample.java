package com.saudeMental;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoClientConnectionExample {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://sudemental:saude123456@conhecimento.jproi.mongodb.net/?retryWrites=true&w=majority&appName=conhecimento";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("saudeMentalDB"); // Nome do seu banco de dados
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");

                // Criar uma instância do DatabaseHandler
                DatabaseHandler dbHandler = new DatabaseHandler(database);

                // Exemplo de uso: salvar resultados
                dbHandler.salvarResultados("Personagem1", 80, 70, 30, 50);

            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}