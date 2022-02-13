import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.Scanner;

import static com.mongodb.client.model.Projections.*;

public class App {
    public static void main(String[] args) {


        try{
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
                addDeveloper();
            }


        } catch (ParseException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    private static void getDays(MongoCollection<Document> developers) {
        Bson filter = Filters.empty();
        Bson projection = fields(include("date"), exclude("_id"));
        System.out.println("******************* Lista fechas ******************************");
        developers.find(filter).projection(projection).forEach(doc -> System.out.println(doc.toString()));

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

    public static void addDeveloper(){

        System.out.println("************ Alta developer ******************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca nombre:");
        String name = scanner.nextLine();
        System.out.println("Introduzca email:");
        String email = scanner.nextLine();
        System.out.println("Introduzca telefono:");
        String phone = scanner.nextLine();
        System.out.println("Introduzca fecha: (Ejemplo: Abr 1,2021)");
        String date = scanner.nextLine();

    }

}
