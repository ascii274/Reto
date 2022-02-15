import com.ascii274.reto.dto.Categoria;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import controller.DeveloperController;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Projections.*;


public class App {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver.connection").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.management").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.cluster").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.protocol.insert").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.protocol.query").setLevel(Level.OFF);
        Logger.getLogger("org.mongodb.driver.protocol.update").setLevel(Level.OFF);

        try{
            DeveloperController developerController = new DeveloperController();
            
            MongoClient client = MongoClients.create();

            MongoDatabase database = client.getDatabase("db-developers");
            MongoCollection<Document> developers = database.getCollection("developers");

            Options options = new Options();
            options.addOption("disday", "displayDay", false, "Display days" );
            options.addOption("lisdev", "listDevelop", false, "Listing developers" );
            options.addOption("addev", "adDevelop", false, "Adding developers" );

            CommandLine line = new DefaultParser().parse(options,args);

            if (line.hasOption("disday")){
                getDays(developers);
            }

            if (line.hasOption("lisdev")){
                listDevelopers(developers);
            }

            if(line.hasOption("addev")){
                developerController.insertDeveloper();
            }


        } catch (ParseException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    //lambda version
    private static void getDays(MongoCollection<Document> developers) {
        Bson filter = Filters.empty();
        Bson projection = fields(include("date"), exclude("_id"));
        System.out.println("******************* Lista fechas ******************************");
        developers.find(filter).projection(projection).forEach(doc -> System.out.println(doc.toString()));
    }

    private static void getDays_2(MongoCollection<Document> developers) {
        Bson filter = Filters.empty();
        Bson projection = fields(include("date"), exclude("_id"));
        System.out.println("******************* Lista fechas ******************************");
        MongoCursor<Document> cursor= developers.find(filter).projection(projection).iterator();
        try{
            while (cursor.hasNext()){
                System.out.println(cursor.next().toString());
            }
        }finally {
            cursor.close();
        }
    }

    private static void listDevelopers(MongoCollection<Document> developers) {
        System.out.println("******************* Lista developers ******************************");
        MongoCursor<Document> cursor = developers.find().iterator();
            try{
                while (cursor.hasNext()){
                    System.out.println(cursor.next().toString());
                }
            }finally {
                cursor.close();
            }
    }


}
