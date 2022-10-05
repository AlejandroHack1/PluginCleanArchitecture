package co.com.bancolombia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoObjectConfig {

    @Value("$(mongoConfig.user)")
    private String dbUser;
    @Value("$(mongoConfig.password)")
    private String dbPassword;
    @Value("$(mongoConfig.database)")
    private String dbName;
    @Value("$(mongoConfig.connectionString)")
    private String dbConnectionString;

    @Bean
    public MongoDatabaseFactory mongoDbFactory(){
        return new SimpleMongoClientDatabaseFactory("mongodb://root:example@192.168.1.8:27017/clean-architecture?authSource=admin");
    }

    /*@Bean
    public MongoDatabaseFactory mongoDbFactory(){
        MongoClientURI uri = new MongoClientURI("mongodb://root:example@192.168.1.8:27017");
        MongoClient mongoClient = new MongoClient(uri);
        return new SimpleMongoClientDatabaseFactory(mongoClient, this.dbName);
    }*/

    @Bean
    public MongoTemplate mongoTemplate(){
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
