package com.saudeMental;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseHandler {

    private MongoDatabase database;

    public DatabaseHandler(MongoDatabase database) {
        this.database = database;
    }

    public void salvarResultados(String nomePersonagem, int energia, int felicidade, int estresse, int pontuacao) {
        MongoCollection<Document> collection = database.getCollection("resultados");

        Document resultado = new Document("nomePersonagem", nomePersonagem)
                .append("energia", energia)
                .append("felicidade", felicidade)
                .append("estresse", estresse)
                .append("pontuacao", pontuacao);

        collection.insertOne(resultado);
        System.out.println("Resultado salvo com sucesso!");
    }
}
