package furkandetseli.jenerator.Database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnector {
    private MongoClient client;
    private MongoDatabase database;

    public DatabaseConnector(String connectionString, String databaseName) {
        MongoClientURI uri = new MongoClientURI(connectionString);
        client = new MongoClient(uri);
        database = client.getDatabase(databaseName);
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
